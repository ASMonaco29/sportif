package src;

import cda.ListeQuestionnaires;
import cda.ListeSportifs;
import cda.ListeSports;
import cda.Question;
import cda.Questionnaire;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.DefaultListModel;
import javax.swing.table.AbstractTableModel;


@SuppressWarnings("serial")
public class ModelTableauSp extends AbstractTableModel {
  
  private final ListeSportifs sportifs;
  private ListeQuestionnaires questionnaires;
  private ListeSports sports;

  private final String[] entetes = {"Pseudo", "Nom", "Prénom", "Date de naissance", 
      "Sport", "Questionnaire(s) attribué(s)"};
  
  @SuppressWarnings("rawtypes")
  private ArrayList<DefaultListModel> modl;
  private ArrayList<Question> questions;
  private ArrayList<Question> questions1;
  private ArrayList<Question> questions2;
  private ArrayList<Question> questions3;
  private ArrayList<Question> questions4;
  private ArrayList<Question> questions5;

  private Calendar cal;
  private Date date1;
  private Date date2;  
  private Date date3;
  private Date date4;
  
  /** Modèle pour le tableau de sportifs.
  * 
  */
  @SuppressWarnings("rawtypes")
  public ModelTableauSp() {
    super();
      
    this.sportifs = new ListeSportifs();
    this.questionnaires = new ListeQuestionnaires();
    this.sports = new ListeSports();
    this.modl = new ArrayList<DefaultListModel>();
    
    this.questions = new ArrayList<Question>();
    this.questions1 = new ArrayList<Question>();
    this.questions2 = new ArrayList<Question>();
    this.questions3 = new ArrayList<Question>();
    this.questions4 = new ArrayList<Question>();
    this.questions5 = new ArrayList<Question>();
    
    questions.add(new Question("Bien ?", false));
    questions.add(new Question("Reveillé ?", true));
    questions.add(new Question("Debout ?", true));
    questions1.add(new Question("Good ?", false));
    questions1.add(new Question("Awake ?", false));
    questions1.add(new Question("Wake up ?", false));
    questions2.add(new Question("Dur réveil ?", true));
    questions2.add(new Question("Debout avant 8h ?", true));
    questions2.add(new Question("Couché avant minuit ?", true));
    questions3.add(new Question("Bonne journée ?", false));
    questions3.add(new Question("Avez-vous pensé positivement ?", false));
    questions3.add(new Question("Avez-vous fait une sieste ?", true));
    questions4.add(new Question("Blessé ?", false));
    questions4.add(new Question("Repos forcé ?", true));
    questions4.add(new Question("Expulsé temporairement ?", false));
    questions5.add(new Question("Heureux ?", true));
    questions5.add(new Question("Souriez-vous assez ?", true));
    questions5.add(new Question("Vous levez-vous du bon pied ?", false));
    
    sports.addSport("Handball");
    sports.addSport("Basketball");
    sports.addSport("Natation");
    sports.addSport("Rugby");
    sports.addSport("Cyclisme");
    sports.addSport("Patinage_artistique");
    sports.addSport("Surf");
    sports.addSport("Ski_de_fond");
    sports.addSport("Ju_Jitsu");
    sports.addSport("Billard");
    sports.addSport("Kite_surf");
    sports.addSport("Pétanque");
    sports.addSport("Escrime");
    sports.addSport("Golf");
    sports.addSport("Football");
     
    
    this.cal = Calendar.getInstance();
    cal.set(Calendar.YEAR, 1996);
    cal.set(Calendar.MONTH, 4);
    cal.set(Calendar.DAY_OF_MONTH, 06);
    date1 = cal.getTime();
    
    cal.set(Calendar.YEAR, 1997);
    cal.set(Calendar.MONTH, 3);
    cal.set(Calendar.DAY_OF_MONTH, 01);
    date2 = cal.getTime();
    
    cal.set(Calendar.YEAR, 1998);
    cal.set(Calendar.MONTH, 3);
    cal.set(Calendar.DAY_OF_MONTH, 28);
    date3 = cal.getTime();
    
    cal.set(Calendar.YEAR, 1995);
    cal.set(Calendar.MONTH, 4);
    cal.set(Calendar.DAY_OF_MONTH, 01);
    date4 = cal.getTime();
    
    questionnaires.addQuestionnaire("Bien-être", "Soin", date1, date2, 
          "Merci d'avoir répondu à ce questionnaire.", questions);
    questionnaires.addQuestionnaire("Santé", "Pour vous", date3, date4, 
          "Merci d'avoir répondu à ce questionnaire.", questions1);
    questionnaires.addQuestionnaire("Lève-tôt-tard", "Repos !", date3, date4, 
          "Merci d'avoir répondu à ce questionnaire.", questions2);
    questionnaires.addQuestionnaire("Satisfaction", "et vous ?", date3, date4, 
          "Merci d'avoir répondu à ce questionnaire.", questions3);
    questionnaires.addQuestionnaire("Situation", "En ce moment...", date3, date4, 
          "Merci d'avoir répondu à ce questionnaire.", questions4);
    questionnaires.addQuestionnaire("La joie", "Heureux ?", date3, date4, 
          "Merci d'avoir répondu à ce questionnaire.", questions5);
          
    sportifs.creerSportif("Alleno", "Malou", "Malou22", date2, sports.getListSports().get(0));
    sportifs.creerSportif("Mestre", "Quentin", "Quentin974", date4, sports.getListSports().get(1));
    sportifs.creerSportif("Le Pape", "Rémi", "Rems56", date3, sports.getListSports().get(2));
    sportifs.creerSportif("Amicel", "Yoann", "Yoyo22", date1, sports.getListSports().get(3));
    
    sportifs.getListeS().get(0).ajouterListQ(questionnaires.getListQ());
    sportifs.getListeS().get(1).ajouterListQ(questionnaires.getListQ());
    sportifs.getListeS().get(2).ajouterListQ(questionnaires.getListQ());
    sportifs.getListeS().get(3).ajouterListQ(questionnaires.getListQ());
    
    
    // Présentation sous forme de liste des questions de chaque questionnaire
    actualiserListeQuestionnaires();
  }

  public int getRowCount() {
    return this.sportifs.getSizeListS();
  }

  public int getColumnCount() {
    return this.entetes.length;
  }
  
  public ListeSportifs getListeSportifs() {
    return this.sportifs;
  }
  
  public ListeSports getListeSports() {
    return this.sports;
  }

  public String getColumnName(int columnIndex) {
    return this.entetes[columnIndex];
  }

  /** Permet la construction du tableau de sportifs.
  * Les paramètres correspondent à la colonne / ligne sélectionnées dans le tableau.
  */
  public Object getValueAt(int rowIndex, int columnIndex) {
    switch (columnIndex) {
      case 0:
        return this.sportifs.getListeS().get(rowIndex).getPseudo();
      case 1:
        return this.sportifs.getListeS().get(rowIndex).getNom();
      case 2:
        return this.sportifs.getListeS().get(rowIndex).getPrenom();
      case 3:
        return this.sportifs.getListeS().get(rowIndex).getNaissance();
      case 4:
        return this.sportifs.getListeS().get(rowIndex).getSport();
      case 5:
        return this.modl.get(rowIndex);
      default:
        return null; // Ne devrait jamais arriver
    }
  }
  
  @Override  
  public boolean isCellEditable(int rowIndex, int columnIndex) { 
    if (columnIndex == 5) {
      return true; // permet au JScrollPane de fonctionner !
    } else {
      return false;
    }
    
  }
  
  
  /** Permet d'ajouter un sportif dans la liste.
  * les paramètres correspondent aux informations du nouveau sportif
  */
  public void creerSportif(String nom, String prenom, String pseudo, Date date, String sport) {
    this.sportifs.creerSportif(nom, prenom, pseudo, date, sport);
    actualiserListeQuestionnaires();
    
    
    fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);
  }
  
  /** Permet de supprimer un sportif dans la liste.
  * @param rowIndex index du sportif à supprimer dans la liste
  */
  public void supprimerSportif(int rowIndex) {
    this.sportifs.supprimerSportif(this.sportifs.getListeS().get(rowIndex).getPseudo());
    this.modl.remove(rowIndex);
    actualiserListeQuestionnaires();
    
    fireTableRowsDeleted(rowIndex, rowIndex);
  }
  
  /** Permet de modifier un sportif dans la liste.
  * les paramètres correspondent aux informations du nouveau sportif
  * @param indx index du sportif à modifier dans la liste
  */
  public void modifSportif(String nom, String prenom, String pseudo, Date date, 
      String sport, int indx) {
    this.sportifs.modifierSportif(nom, prenom, pseudo, date, sport);
    
    fireTableRowsUpdated(indx, indx);
  }
  
  /** Permet de modifier la liste des questionnaires d'un sportif dans la liste.
  * les paramètres correspondent aux informations du nouveau sportif
  * @param indx index du sportif à modifier dans la liste
  */
  public void modifQuestSportif(String pseudo, ArrayList<Questionnaire> quest, int indx) {
    this.sportifs.modifierQuestSportif(pseudo, quest);
    actualiserListeQuestionnaires();
    
    fireTableRowsUpdated(indx, indx);
  }
  
  
  /****************** SPORTS ****************************/
  public void ajouterSport(String sp) {
    this.sports.addSport(sp);
  }
  
  public void supprimerSport(int indx) {
    this.sports.removeSport(indx);
  }
  
  public void modifierSport(String sp, int indx) {
    this.sports.updateSport(sp, indx);
  }
  
  
  
  @SuppressWarnings({ "unchecked", "rawtypes" })
  @Override
  public Class getColumnClass(int columnIndex) {
    switch (columnIndex) {
      case 3:
        return Date.class;
      default:
        return Object.class;
    }
  }
  
  
  /** Permet d'actualiser la liste de questions dans le tableau de questionnaires.
  * 
  */
  @SuppressWarnings({ "rawtypes", "unchecked" })
  public void actualiserListeQuestionnaires() {
    this.modl.clear();
    for (int i = 0; i < getRowCount(); i++) {
      if (sportifs.getListeS().get(i).getquListe() != null) {
        DefaultListModel dlm = new DefaultListModel();
        for (int j = 0; j < sportifs.getListeS().get(i).getquListe().size(); j++) {
          dlm.addElement(sportifs.getListeS().get(i).getquListe().get(j));
        }
        this.modl.add(dlm);
      } else {
        DefaultListModel dlm = new DefaultListModel();
        this.modl.add(dlm);
      }
    }
  }
  
  
}
  