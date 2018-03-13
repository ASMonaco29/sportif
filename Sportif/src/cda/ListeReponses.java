package cda;

import java.util.ArrayList;

public class ListeReponses {
  private Sportif sportif;
  private Questionnaire questionnaire;
  private ArrayList<Reponse> reponses;
  
  public ListeReponses() {
    super();
    this.reponses = new ArrayList<Reponse>();
    this.questionnaire = new Questionnaire(null, null);
    this.sportif = new Sportif();
  }

  public void addListeReponses(Reponse reponse) {
    this.reponses.add(reponse);
  }
  
  public void removeListeReponses(Reponse reponse) {
    int i=0;
    for(Reponse reponse2 : reponses) {
      if(reponse2==reponse) {
        this.reponses.remove(i);
      }
      i++;
    }  
  }
  
  public Sportif getSportif() {
    return sportif;
  }

  public void setSportif(Sportif sportif) {
    this.sportif = sportif;
  }

  public Questionnaire getQuestionnaire() {
    return questionnaire;
  }

  public void setQuestionnaire(Questionnaire questionnaire) {
    this.questionnaire = questionnaire;
  }

  public ArrayList<Reponse> getReponses() {
    return reponses;
  }

  public void setReponses(ArrayList<Reponse> reponses) {
    this.reponses = reponses;
  }
  
}
