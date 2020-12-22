import { Component, OnInit } from "@angular/core";
import { Calculation } from "../calculation";
import { CalculatorService } from "../calculator.service";
import { OperationType } from "../operation-type.enum";
import { FormBuilder, FormGroup } from "@angular/forms";

@Component({
  selector: "app-calculator",
  templateUrl: "./calculator.component.html",
  styleUrls: ["./calculator.component.css"],
})
export class CalculatorComponent implements OnInit {
  operationType = OperationType;
  calculationsForm: FormGroup;
  numberOfCalculationsInForm: number = 5;
  calculated: Array<Calculation> = [];

  constructor(
    private calculatorService: CalculatorService,
    private formBuilder: FormBuilder
  ) {}

  ngOnInit(): void {
    this.createForm();
    this.retrieveCalculations();
  }

  calculate() {
    const filteredCalculations = this.calculationsForm.value.calculations.filter(
      this.isValidCalculation
    );
    this.calculatorService
      .calculate(filteredCalculations)
      .subscribe((data) => (this.calculated = this.calculated.concat(data)));
  }

  retrieveCalculations(): void {
    this.calculatorService.retrieveCalculations().subscribe((data) => {
      data.forEach((calculation: Calculation) => {
        this.calculated.push(calculation);
      });
    });
  }

  createForm(): void {
    const formGroupArray: Array<FormGroup> = [];
    for (let i = 0; i < this.numberOfCalculationsInForm; i++) {
      formGroupArray.push(
        this.formBuilder.group({
          left: [null],
          right: [null],
          operation: [null],
        })
      );
    }
    this.calculationsForm = this.formBuilder.group({
      calculations: this.formBuilder.array(formGroupArray),
    });
  }

  getCalculationSymbol(operationType: OperationType): string {
    switch (operationType) {
      case "ADD":
        return "+";
      case "SUBTRACT":
        return "-";
      case "MULTIPLY":
        return "*";
      case "DIVIDE":
        return "/";
      default:
        return null;
    }
  }

  isValidCalculation(calculation: Calculation) {
    return !(
      calculation.left === null ||
      calculation.right === null ||
      calculation.operation === null ||
      (calculation.operation === OperationType.Divide &&
        calculation.right === 0)
    );
  }

  numberOfCalculationsInFormChanged(): void {
    this.createForm();
  }

  fillRandomly(): void {
    this.calculationsForm.get("calculations")["controls"].forEach((element) => {
      element.controls.left.setValue(this.createRandomNumber());
      element.controls.right.setValue(this.createRandomNumber());
      element.controls.operation.setValue(this.getRandomEnumValue());
      element.pristine = false;
    });
  }

  createRandomNumber(): number {
    return Math.floor(Math.random() * 201) - 100;
  }

  getRandomEnumValue(): OperationType {
    const randomInt = Math.floor(Math.random() * 4) + 1;
    switch (randomInt) {
      case 1:
        return OperationType.Add;
      case 2:
        return OperationType.Subtract;
      case 3:
        return OperationType.Multiply;
      case 4:
        return OperationType.Divide;
      default:
        return null;
    }
  }
}
