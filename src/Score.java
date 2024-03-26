public class Score {
  private int score;
  private int lastScore; 
  private int bestScore;

  // Constructor
  public Score() {
    this.score = 0;
    this.lastScore = 0; 
    this.bestScore = 0;
  }

  // Set lastScore
  void setLastScore(int v)
  {
    this.lastScore = v;
  }

  // Get last score string
  String getLastScoreString()
  {
    return Integer.toString(this.lastScore);
  }

  // Set best score
  void setBestScore(int v)
  {
    if(v > this.bestScore) this.bestScore = v;
  }

  // Get best score string 
  String getBestScoreString()
  {
    return Integer.toString(this.bestScore);
  }

  // Next Score
  public void increaseScore() {
    this.score++;
  }

  // Reset score
  public void resetScore() {
    this.score = 0;
  }

  // Get score value
  public int getScore() {
    return this.score;
  }

  public String getScoreString()
  {
    return Integer.toString(this.score);
  }
}
