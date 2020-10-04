// Implement Stack Using Array 

class Stack {

  int top;
  int maxSize;
  int[] data;

  Stack(int max){

    top=-1;
    maxSize = max;
    data = new int[maxSize];
  }

  public boolean isFull() {

    return (top == maxSize -1);

  }

  public boolean isEmpty() {

    return (top == -1);
  }

  public void push(int d) {

    if(isFull() == false){

      data[++top] = d;

    }
  }

  public int pop() {

    if(isEmpty() == false){

      return data[top--];
    }

    else {
      return -1;
    }
  }

}

class StackMain {

  public static void main(String[] args) {

    Stack s1 = new Stack(5);

    s1.push(1);
    s1.push(2);
    s1.push(3);
    s1.push(4);

    System.out.println(s1.pop());

  }
}
