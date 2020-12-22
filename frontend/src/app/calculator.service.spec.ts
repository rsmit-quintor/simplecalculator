import { TestBed } from "@angular/core/testing";
import {
  HttpClientTestingModule,
  HttpTestingController,
} from "@angular/common/http/testing";
import { CalculatorService } from "./calculator.service";
import { environment } from "src/environments/environment";
import { OperationType } from "./operation-type.enum";
import { Calculation } from "./calculation";

describe("CalculatorService", () => {
  let service: CalculatorService;
  let httpMock: HttpTestingController;
  let httpClient: HttpClientTestingModule;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [HttpClientTestingModule],
    });
    service = TestBed.inject(CalculatorService);
    httpMock = TestBed.inject(HttpTestingController);
    httpClient = TestBed.inject(HttpClientTestingModule);
  });

  it("should be created", () => {
    expect(service).toBeTruthy();
  });

  it("should retrieve calculations", () => {
    const dummyCalculations = [new Calculation(1, 2, OperationType.Add)];
    const retrievedCalculations = service
      .retrieveCalculations()
      .subscribe((data) => {
        expect(data).toEqual(dummyCalculations);
      });
    const request = httpMock.expectOne(`${environment.contextPath}/history`);
    request.flush(dummyCalculations);

    expect(request.request.method).toBe("GET");
  });

  it("should retrieve calculations", () => {
    const dummyCalculations = [new Calculation(1, 2, OperationType.Add)];
    const resultCalculations = dummyCalculations.map((c) => {
      let copy = { ...c };
      copy.outcome = 3;
      return copy;
    });
    const retrievedCalculations = service
      .calculate(dummyCalculations)
      .subscribe((data) => {
        expect(data).toEqual(resultCalculations);
      });
    const request = httpMock.expectOne(`${environment.contextPath}/calculate`);
    request.flush(resultCalculations);

    expect(request.request.method).toBe("POST");
  });
});
