import { async, ComponentFixture, TestBed } from "@angular/core/testing";
import { FormBuilder } from "@angular/forms";
import { Observable } from "rxjs";
import { CalculatorService } from "../calculator.service";
import { of } from "rxjs";

import { CalculatorComponent } from "./calculator.component";
import { Calculation } from "../calculation";
import { OperationType } from "../operation-type.enum";

describe("CalculatorComponent", () => {
  let component: CalculatorComponent;
  let fixture: ComponentFixture<CalculatorComponent>;
  let mockCalculatorService = jasmine.createSpyObj([
    "retrieveCalculations",
    "calculate",
  ]);

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [CalculatorComponent],
      providers: [
        { provide: CalculatorService, useValue: mockCalculatorService },
        { provide: FormBuilder },
      ],
    }).compileComponents();
  }));

  beforeEach(() => {
    mockCalculatorService.retrieveCalculations.and.returnValue(of([]));
    fixture = TestBed.createComponent(CalculatorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it("should create", () => {
    expect(component).toBeTruthy();
  });

  it("should call funcions on initialization", () => {
    spyOn(component, "createForm");
    spyOn(component, "retrieveCalculations");
    component.ngOnInit();
    expect(component.createForm).toHaveBeenCalled();
    expect(component.retrieveCalculations).toHaveBeenCalled();
  });

  it("should calculate valid calculations", () => {
    component.calculated = [];
    const dummyCalculations = [new Calculation(1, 2, OperationType.Add)];
    const resultCalculations = dummyCalculations.map((c) => {
      let copy = { ...c };
      copy.outcome = 3;
      return copy;
    });
    let filterSpy = spyOn(
      component.calculationsForm.value.calculations,
      "filter"
    ).and.returnValue(dummyCalculations);
    mockCalculatorService.calculate.and.returnValue(of(resultCalculations));

    component.calculate();

    expect(component.calculated).toEqual(resultCalculations);
    expect(filterSpy).toHaveBeenCalled();
    expect(mockCalculatorService.calculate).toHaveBeenCalledWith(
      dummyCalculations
    );
  });

  it("should be able to retrieve all previous calculations", () => {
    component.calculated = [];
    let dummyCalculation = new Calculation(1, 2, OperationType.Add);
    dummyCalculation.outcome = 3;
    let dummyCalculations = [dummyCalculation];
    mockCalculatorService.retrieveCalculations.and.returnValue(
      of(dummyCalculations)
    );
    component.retrieveCalculations();
    expect(component.calculated).toEqual(dummyCalculations);
  });

  it("should build a form with a set number of inputs", () => {
    component.numberOfCalculationsInForm = 10;
    component.createForm();
    expect(
      component.calculationsForm.get("calculations")["controls"].length
    ).toBe(10);

    component.numberOfCalculationsInForm = 20;
    component.createForm();
    expect(
      component.calculationsForm.get("calculations")["controls"].length
    ).toBe(20);
  });

  it("should get right calculation symbol by enum value", () => {
    expect(component.getCalculationSymbol(OperationType.Add)).toBe("+");
    expect(component.getCalculationSymbol(OperationType.Subtract)).toBe("-");
    expect(component.getCalculationSymbol(OperationType.Multiply)).toBe("*");
    expect(component.getCalculationSymbol(OperationType.Divide)).toBe("/");
    expect(component.getCalculationSymbol(null)).toBe(null);
  });

  it("should validate calculations", () => {
    const calculation = new Calculation(null, null, null);
    expect(component.isValidCalculation(calculation)).toBe(false);
    calculation.left = 1;
    expect(component.isValidCalculation(calculation)).toBe(false);
    calculation.right = 0;
    expect(component.isValidCalculation(calculation)).toBe(false);
    calculation.operation = OperationType.Divide;
    expect(component.isValidCalculation(calculation)).toBe(false);
    calculation.operation = OperationType.Add;
    expect(component.isValidCalculation(calculation)).toBe(true);
  });

  it("should create new form if user wants different number of calculations", () => {
    spyOn(component, "createForm");
    component.numberOfCalculationsInFormChanged();
    expect(component.createForm).toHaveBeenCalled();
  });

  it("should be able to fill the form with random inputs", () => {
    spyOn(component, "createRandomNumber").and.returnValue(9);
    spyOn(component, "getRandomEnumValue").and.returnValue(OperationType.Add);
    component.numberOfCalculationsInForm = 10;
    component.createForm();

    component.fillRandomly();

    let isFunctionSuccesful = component.calculationsForm
      .get("calculations")
      ["controls"].every((element) => {
        return (
          element.controls.left.value === 9 &&
          element.controls.right.value === 9 &&
          element.controls.operation.value === OperationType.Add
        );
      });
    expect(isFunctionSuccesful).toBe(true);
  });

  it("should be able to get a random enum value", () => {
    let spy = spyOn(Math, "floor").and.returnValue(0);
    expect(component.getRandomEnumValue()).toBe(OperationType.Add);
    spy.and.returnValue(1);
    expect(component.getRandomEnumValue()).toBe(OperationType.Subtract);
    spy.and.returnValue(2);
    expect(component.getRandomEnumValue()).toBe(OperationType.Multiply);
    spy.and.returnValue(3);
    expect(component.getRandomEnumValue()).toBe(OperationType.Divide);
    spy.and.returnValue(4);
    expect(component.getRandomEnumValue()).toBe(null);
  });
});
