import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import src.Apple;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gameplay extends JPanel implements KeyListener, ActionListener {
  // Declare snake object
  Snake snake = new Snake();

  // Declare apple object
  Apple apple = new Apple();

  // Declare score object
  Score score = new Score();

  // Images
  private ImageIcon mainLogo;

  // Timer for movement
  private Timer timer;
  private int delay = 500;

  // Snake value
  private ImageIcon snakeBody;
  private ImageIcon snakeHead;
  // Pos
  private int snakeHeadXPos = 379;

  // Key asignment
  private int eventUp = KeyEvent.VK_UP;
  private int eventDw = KeyEvent.VK_DOWN;
  private int eventRight = KeyEvent.VK_RIGHT;
  private int eventLeft = KeyEvent.VK_LEFT;

  // Apple
  ImageIcon appleImage;
  // Apple pos
  private Random random = new Random();

  private int xPos = random.nextInt(100);
  private int yPos = random.nextInt(100);

  public Gameplay() {
    // buat pas mulai gamenya
    addKeyListener(this);
    setFocusable(true);
    setFocusTraversalKeysEnabled(false);
    timer = new Timer(delay, this);
    timer.start();
  }

  // Paint function
  public void paint(Graphics g) {
    // Check if game is started
    if (snake.snakeMoves == 0) {
      for (int i = 0; i < 5; i++) {
        snake.snakeLengthX[i] = snakeHeadXPos;
        snakeHeadXPos -= 6;
        snake.snakeLenghtY[i] = 355;
      }
    }
    // Print score | menu | options rectangle
    g.setColor(Color.WHITE);
    g.drawRect(670, 10, (910 - 700), 650);
    g.setColor(Color.DARK_GRAY);
    g.fillRect(671, 11, (910 - 700) - 1, 650 - 1);
    // Print game base rectangle
    g.setColor(Color.WHITE);
    g.drawRect(10, 10, 650, 650);
    g.setColor(Color.DARK_GRAY);
    g.fillRect(11, 11, 650 - 1, 650 - 1);
    // Print main logo
    mainLogo = new ImageIcon("assets/images/main_logo.png");
    final int logoHeight = 190;
    final int logoWidth = 190;
    Image resizeImage = mainLogo.getImage().getScaledInstance(logoWidth, logoHeight, Image.SCALE_SMOOTH);
    mainLogo = new ImageIcon(resizeImage);
    mainLogo.paintIcon(this, g, 680, 20);
    // Score text
    g.setColor(Color.BLUE);
    g.setFont(new Font("Helvetica", Font.BOLD, 16));
    g.drawString("PUNTEGGIO", 680, (190 + 20 + 30));
    // Paint score value
    g.setColor(Color.BLUE);
    g.drawRect(680, (190 + 20 + 40), (910 - 720), 40);
    // Score value
    g.setColor(Color.WHITE);
    g.setFont(new Font("Helvetica", Font.BOLD, 20));
    g.drawString(score.getScoreString(), 690, (190 + 20 + 40 + 28));
    // Paint last score value
    if (!score.getLastScoreString().equals("0")) {
      g.setColor(Color.GREEN);
      g.setFont(new Font("Helvetica", Font.BOLD, 12));
      g.drawString("Ultimo punteggio", 680, (190 + 20 + 30 + 70));
      g.setColor(Color.GREEN);
      g.drawRect(680, (190 + 20 + 40 + 70), (910 - 720), 40);
      // Score value
      g.setColor(Color.white);
      g.setFont(new Font("Helvetica", Font.BOLD, 20));
      g.drawString(score.getScoreString(), 690, (190 + 20 + 40 + 28 + 70));
    }
    // Paint best score
    if (!score.getBestScoreString().equals("0")) {
      g.setColor(Color.RED);
      g.setFont(new Font("Helvetica", Font.BOLD, 12));
      g.drawString("Migior punteggio", 680, (190 + 20 + 30 + 70 + 70));
      g.setColor(Color.RED);
      g.drawRect(680, (190 + 20 + 40 + 70 + 70), (910 - 720), 40);
      // Score value
      g.setColor(Color.white);
      g.setFont(new Font("Helvetica", Font.BOLD, 20));
      g.drawString(score.getBestScoreString(), 690, (190 + 20 + 40 + 28 + 70 + 70));
    }

    // Print LICENSE
    g.setColor(Color.white);
    g.setFont(new Font("Helvetica", Font.BOLD, 12));
    g.drawString("LICENSE FREEWERE", 650 / 2, 685);

    // Print snake
    snakeHead = new ImageIcon("assets/images/snakeHead4.png");
    snakeHead.paintIcon(this, g, snake.snakeLengthX[0], snake.snakeLenghtY[0]);

    for (int i = 0; i < snake.snakeLenght; i++) {
      if (i == 0 && (snake.snakeMoveRight || snake.snakeMoveLeft || snake.snakeMoveUp || snake.snakeMoveDown)) {
        snakeHead = new ImageIcon("assets/images/snakeHead4.png");
        snakeHead.paintIcon(this, g, snake.snakeLengthX[i], snake.snakeLenghtY[i]);
      }
      if (i != 0) {
        snakeBody = new ImageIcon("assets/images/snakeimage4.png");
        snakeBody.paintIcon(this, g, snake.snakeLengthX[i], snake.snakeLenghtY[i]);
      }
    }

    // Apple
    appleImage = new ImageIcon("assets/images/apple.png");
    if ((apple.applexPos[xPos]) == snake.snakeLengthX[0] && (apple.appleyPos[yPos] == snake.snakeLenghtY[0])) {
      snake.snakeLenght++;
      score.increaseScore();
      xPos = random.nextInt(100);
      yPos = random.nextInt(100);

      // mempercepat gerakan ular tiap kali skor mencapai kelipatan 10
      if (score.getScore() % 5 == 0 && score.getScore() != 0) {
        if (delay > 100) {
          delay = delay - 100;
        } else if (delay == 100) {
          delay = delay - 50;
        } else if (delay <= 50 && delay > 20) {
          delay = delay - 10;
        } else {
          delay = 20;
        }
        timer.setDelay(delay);
      }
    }

    // Print apple
    if (snake.snakeMoves != 0) {
      appleImage.paintIcon(this, g, apple.applexPos[xPos], apple.appleyPos[yPos]);
    }

    // Check if the snake pull the body
    for (int i = 1; i < snake.snakeLenght; i++) {
      if (snake.snakeLengthX[i] == snake.snakeLengthX[0] && snake.snakeLenghtY[i] == snake.snakeLenghtY[0]) {
        // Set dead
        snake.dead();
      }
    }

    // Drow init game screen
    if (snake.snakeMoves == 0) {
      g.setColor(Color.WHITE);
      g.setFont(new Font("Courier New", Font.BOLD, 26));
      g.drawString("Press Spacebar to Start the Game!", 70, 300);
    }

    // Drow GAME OVER screen
    if (snake.snakeDeath) {
      // Save last score
      score.setLastScore(score.getScore());
      // Save top score if biggest then prev top score
      score.setBestScore(score.getScore());

      // menampilkan tulisan "Game Over!"
      g.setColor(Color.RED);
      g.setFont(new Font("Courier New", Font.BOLD, 50));
      g.drawString("Game Over!", 190, 340);

      // menampilkan score
      g.setColor(Color.GREEN);
      g.setFont(new Font("Courier New", Font.BOLD, 18));
      g.drawString("Your Score : " + score.getScore(), 250, 370);

      // menampilkan tulisan "Press Spacebar to restart!"
      g.setColor(Color.WHITE);
      g.setFont(new Font("Courier New", Font.BOLD, 20));
      g.drawString("Press Spacebar to restart!", 187, 400);
    }
    g.dispose();
  }

  // Key listeners
  @Override
  public void keyPressed(KeyEvent arg0) {
    int keyCodePressed = arg0.getKeyCode();
    System.out.println("Button press" + keyCodePressed); // Print statement
    // Check button pressed
    if (keyCodePressed == KeyEvent.VK_SPACE) {
      // Init game
      if (snake.snakeMoves == 0) {
        snake.snakeMoves++;
        snake.snakeMoveRight = true;
      }
      // restart new game
      if (snake.snakeDeath) {
        snake.snakeMoves = 0;
        snake.snakeLenght = 5;
        score.resetScore();
        repaint();
        snake.snakeDeath = false;
      }
    } else if (keyCodePressed == eventUp) {
      snake.moveUp();
    } else if (keyCodePressed == eventDw) {
      snake.moveDown();
    } else if (keyCodePressed == eventRight) {
      snake.moveRight();
    } else if (keyCodePressed == eventLeft) {
      snake.moveLeft(); // Ensure moveLeft is called here
    } else {
      // TODO Implementare metodo pressione pulsante non definito
    }
  }

  @Override
  public void keyReleased(KeyEvent arg0) {
  }

  @Override
  public void keyTyped(KeyEvent arg0) {
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    timer.start();
    if (snake.snakeMoveRight) {
      snake.movementRight();
    }
    if (snake.snakeMoveLeft) {
      snake.movementLeft();
    }
    if (snake.snakeMoveUp) {
      snake.movementUp();
    }
    if (snake.snakeMoveDown) {
      snake.movementDw();
    }
    if (snake.snakeMoveUp || snake.snakeMoveDown || snake.snakeMoveRight || snake.snakeMoveLeft) {
      repaint();
    }
  }

}
