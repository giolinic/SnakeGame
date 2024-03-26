public class Snake {
  // Snake position arays
  static final int maxSnakeSize = 650;
  int[] snakeLengthX = new int[maxSnakeSize];
  int[] snakeLenghtY = new int[maxSnakeSize];

  // Snake lenght
  int snakeLenght;

  // Moves
  int snakeMoves;

  // Snake movement by key variable
  boolean snakeMoveLeft;
  boolean snakeMoveRight;
  boolean snakeMoveUp;
  boolean snakeMoveDown;

  // Snake life state
  boolean snakeDeath;

  public Snake() {
    this.snakeMoveLeft = false;
    this.snakeMoveRight = false;
    this.snakeMoveUp = false;
    this.snakeMoveDown = false;

    this.snakeDeath = false;
    this.snakeLenght = 5;
    this.snakeMoves = 0;
  }

  public void moveUp() {
    // Check moves value
    if (this.snakeMoves != 0 && !this.snakeDeath) {
      // Increment moves
      this.snakeMoves++;
      if (!this.snakeMoveDown) {
        this.snakeMoveUp = true;
      } else {
        this.snakeMoveUp = false;
        this.snakeMoveDown = true;
      }
      this.snakeMoveLeft = false;
      this.snakeMoveRight = false;
    }
  }

  public void moveDown() {
    if (this.snakeMoves != 0 && !this.snakeDeath) {
      // Increment moves
      this.snakeMoves++;
      if (!this.snakeMoveUp) {
        this.snakeMoveDown = true;
      } else {
        this.snakeMoveUp = true;
        this.snakeMoveDown = false;
      }
      this.snakeMoveLeft = false;
      this.snakeMoveRight = false;
    }
  }

  public void moveRight() {
    // Check moves value
    if (this.snakeMoves != 0 && !this.snakeDeath) {
      // Increment moves
      this.snakeMoves++;
      if (!this.snakeMoveLeft) {
        this.snakeMoveRight = true;
      } else {
        this.snakeMoveRight = false;
        this.snakeMoveLeft = true;
      }
      this.snakeMoveUp = false;
      this.snakeMoveDown = false;
    }
  }

  public void moveLeft() {
    if (this.snakeMoves != 0 && !this.snakeDeath) {
      this.snakeMoves++;
      if (!this.snakeMoveRight) {
        this.snakeMoveLeft = true;
      } else {
        this.snakeMoveLeft = false;
        this.snakeMoveRight = true;
      }
      this.snakeMoveUp = false;
      this.snakeMoveDown = false;
    }
  }

  public void dead() {
    this.snakeMoveUp = false;
    this.snakeMoveDown = false;
    this.snakeMoveRight = false;
    this.snakeMoveLeft = false;
    this.snakeDeath = true;
  }

  public void movementRight() {
    // Y pos
    for (int i = this.snakeLenght - 1; i >= 0; i--) {
      // Y transaction
      this.snakeLenghtY[i + 1] = this.snakeLenghtY[i];
    }
    // X pos
    for (int i = this.snakeLenght - 1; i >= 0; i--) {
      if (i == 0) {
        this.snakeLengthX[i] = this.snakeLengthX[i] + 6;
      } else {
        this.snakeLengthX[i] = this.snakeLengthX[i - 1];
      }
      // Check collision with border right setted to 650
      if (this.snakeLengthX[0] > 650) {
        this.snakeLengthX[i] -= 6;
        // Set dead
        dead();
      }
    }
  }

  public void movementLeft() {
    // Y pos
    for (int i = this.snakeLenght - 1; i >= 0; i--) {
      // Y transactions
      this.snakeLenghtY[i + 1] = this.snakeLenghtY[i];
    }
    // X pos
    for (int i = this.snakeLenght - 1; i >= 0; i--) {
      if (i == 0) {
        this.snakeLengthX[i] = this.snakeLengthX[i] - 6;
      } else {
        this.snakeLengthX[i] = this.snakeLengthX[i - 1];
      }
      // Check collision with border right set to 650
      if (this.snakeLengthX[0] < 25) {
        this.snakeLengthX[0] += 6;
        // Set dead
        dead();
      }
    }
  }

  public void movementUp() {
    // X Pos
    for (int i = this.snakeLenght - 1; i >= 0; i--) {
      // X transaction
      this.snakeLengthX[i + 1] = this.snakeLengthX[i];
    }
    // Y Pos
    for (int i = this.snakeLenght - 1; i >= 0; i--) {
      if (i == 0) {
        this.snakeLenghtY[i] = this.snakeLenghtY[i] - 6;
      } else {
        this.snakeLenghtY[i] = this.snakeLenghtY[i - 1];
      }
      // Check collision with border top setted to 10
      if (this.snakeLenghtY[0] < 10) {
        this.snakeLenghtY[0] += 6;
        // Set dead
        dead();
      }
    }
  }

  public void movementDw() {
    // X Pos
    for (int i = this.snakeLenght - 1; i >= 0; i--) {
      // X transaction
      this.snakeLengthX[i + 1] = this.snakeLengthX[i];
    }
    // Y Pos
    for (int i = this.snakeLenght - 1; i >= 0; i--) {
      if (i == 0) {
        this.snakeLenghtY[i] = this.snakeLenghtY[i] + 6;
      } else {
        this.snakeLenghtY[i] = this.snakeLenghtY[i - 1];
      }
      // Check collision with border bottom setted to 670
      if (this.snakeLenghtY[0] > 650) {
        this.snakeLenghtY[0] -= 6;
        // Set dead
        dead();
      }
    }
  }
}
