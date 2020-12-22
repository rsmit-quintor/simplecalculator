import { OperationType } from "./operation-type.enum";

export class Calculation {
  public left: number;
  public right: number;
  public operation: OperationType;
  public outcome: number;

  constructor(left: number, right: number, operationType: OperationType) {
    this.left = left;
    this.right = right;
    this.operation = operationType;
  }
}
