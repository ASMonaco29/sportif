package src;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import cda.Question;



public class Ihm extends JFrame implements ActionListener {
  
  private static final long serialVersionUID = 1L;
  private ModelTableauQ modeleQ = new ModelTableauQ();
  private JTabbedPane tabbedPane;
  
  // ONGLET GENERAL
 
  // ONGLET QUESTIONNAIRES
  private JComponent panelQ; 
  private JComponent panelQl; 
  private JComponent panelQg;
  private Border borderL;
  private Border borderG;
  private JPanel pTitre;
  private JPanel pStitre;
  private JPanel pDateDebut;
  private JPanel pDateFin;
  private JPanel pMessageFin;
  private JPanel pQuestions;
  private JPanel pBoutons;
  private JTextField tTitre; 
  private JTextField tStitre;
  private JTextField tMessageFin;
  private JLabel lTitre;
  private JLabel lStitre;
  private JLabel lDateDebut;
  private JLabel lDateFin;
  private JLabel lMessageFin;
  private JLabel lQuestions;
  private JLabel triche;
  private JButton bCreer;
  private JButton bModifier;
  private JButton bSupprimer;
  @SuppressWarnings("rawtypes")
  private JComboBox cQuestions;
  private JTable tableauQ;
  private Properties p;
  private UtilDateModel modelDebut;
  private UtilDateModel modelFin;
  private JDatePanelImpl datePanelDebut;
  private JDatePanelImpl datePanelFin;
  private JDatePickerImpl dateDebut;
  private JDatePickerImpl dateFin;

  
  // ONGLET SPORTIFS
  
  // Bouton QUITTER
  private JButton quitter;
  private JPanel panelQuitter;
  private JPanel panelQuitter1;
 
  
  
  /** Constructeur.
  * @param nom Contient le nom de la fenêtre
  */
  public Ihm(String nom) {
               
    this.setSize(670, 580); // Taille de la fenêtre
    this.setTitle(nom); // Titre
    this.setLocationRelativeTo(null); // Position par rapport au centre de l'écran
    this.setResizable(true); // On ne peut pas toucher à la taille de la fenêtre
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); /* Lorsqu'on ferme la fenêtre, 
                                                          le programme se ferme "proprement" */ 
    this.setLayout(new BorderLayout()); // On choisit un BorderLayout pour la fenêtre principale
    this.setMinimumSize(new Dimension(670, 580));
    
    construire();
  }
      
  
  
  /** Construire.
  * Permet de construire la fenêtre
  */
  @SuppressWarnings({ "unchecked", "rawtypes" })
  public void construire() {
   
    
    tabbedPane = new JTabbedPane();  
   
    // ONGLET GENERAL
    JComponent panelG = new JPanel();
   
    // Attributs
   
    // Paramètres de l'onglet Général
    panelG.setLayout(null);
    tabbedPane.addTab("Général", panelG);
    panelG.setPreferredSize(new Dimension(720, 480));
    tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
   
    // Ajout des attributs au contenu de l'onglet Général 

       

    // ONGLET QUESTIONNAIRES
    this.panelQ = new JPanel();
    this.panelQ.setLayout(new BoxLayout(this.panelQ, BoxLayout.PAGE_AXIS));
    this.panelQl = new JPanel();
    this.panelQl.setLayout(new BorderLayout());
    this.panelQl.setMaximumSize(new Dimension(1700, 250));
    this.panelQl.setPreferredSize(new Dimension(this.getWidth(), 250));
    this.panelQg = new JPanel();
   
    // Attributs
    this.borderL = BorderFactory.createTitledBorder("Liste Questionnaires");
    this.borderG = BorderFactory.createTitledBorder("Gérer Questionnaires");
    
    this.bCreer = new JButton("Créer");
    this.bCreer.addActionListener(this);
    this.bModifier = new JButton("Modifier");
    this.bModifier.addActionListener(this);
    this.bSupprimer = new JButton("Supprimer");
    this.bSupprimer.addActionListener(this);
            
    this.tTitre = new JTextField(); 
    this.tTitre.setPreferredSize(new Dimension(250, 25));
    
    this.tStitre = new JTextField();
    this.tStitre.setPreferredSize(new Dimension(250, 25));
       
    this.p = new Properties();
    this.p.put("text.today", "Today");
    this.p.put("text.month", "Month");
    this.p.put("text.year", "Year");
    
    this.modelDebut = new UtilDateModel();
    this.datePanelDebut = new JDatePanelImpl(modelDebut, p);
    this.dateDebut = new JDatePickerImpl(datePanelDebut, new DateLabelFormatter());
    this.dateDebut.setPreferredSize(new Dimension(120, 25));
    
    this.modelFin = new UtilDateModel();
    this.datePanelFin = new JDatePanelImpl(modelFin, p);
    this.dateFin = new JDatePickerImpl(datePanelFin, new DateLabelFormatter());
    this.dateFin.setPreferredSize(new Dimension(120, 25));
    
    this.tMessageFin = new JTextField();
    this.tMessageFin.setPreferredSize(new Dimension(250, 25));
    
    this.lTitre = new JLabel("Titre : ");
    this.lStitre = new JLabel("Sous-titre : ");
    this.lDateDebut = new JLabel("Date début : ");
    this.lDateFin = new JLabel("Date fin : ");
    this.lMessageFin = new JLabel("Message de Fin : ");
    this.lQuestions = new JLabel("Question(s) : ");
    this.triche = new JLabel("                                                               "
        + "                                                                                   "
        + "                                                                                  ");
    
    Object[] valeurs = new Object[]{"Etes-vous en forme ?", 
        "Etes-vous régulièrement blessé ?", "Etes-vous remplaçant ?", 
        "Vous entraînez-vous plus de 20h par semaine ?"};
    this.cQuestions = new JComboBox(valeurs);
    
    this.pTitre = new JPanel();
    this.pTitre.setLayout(new BorderLayout());
    this.pStitre = new JPanel();
    this.pStitre.setLayout(new BorderLayout());
    this.pDateDebut = new JPanel();
    this.pDateFin = new JPanel();
    this.pMessageFin = new JPanel();
    this.pQuestions = new JPanel();
    this.pBoutons = new JPanel();
    this.pBoutons.setLayout(new BoxLayout(this.pBoutons, BoxLayout.LINE_AXIS));
    
    this.pTitre.add(this.lTitre, BorderLayout.WEST);
    this.pTitre.add(this.tTitre, BorderLayout.EAST);
    this.pStitre.add(this.lStitre, BorderLayout.WEST);
    this.pStitre.add(this.tStitre, BorderLayout.EAST);
    this.pDateDebut.add(this.lDateDebut, BorderLayout.WEST);
    this.pDateDebut.add(this.dateDebut, BorderLayout.EAST);
    this.pDateFin.add(this.lDateFin, BorderLayout.WEST);
    this.pDateFin.add(this.dateFin, BorderLayout.EAST);
    this.pMessageFin.add(this.lMessageFin, BorderLayout.WEST);
    this.pMessageFin.add(this.tMessageFin, BorderLayout.EAST);
    this.pQuestions.add(this.lQuestions, BorderLayout.WEST);
    this.pQuestions.add(this.cQuestions, BorderLayout.EAST);
    
    this.pBoutons.add(this.bCreer); 
    this.pBoutons.add(Box.createRigidArea(new Dimension(200,0)));
    this.pBoutons.add(this.bModifier);
    this.pBoutons.add(Box.createRigidArea(new Dimension(200,0)));
    this.pBoutons.add(this.bSupprimer);
    
    tableauQ = new JTable(modeleQ);
    tableauQ.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    tableauQ.getColumn("Question(s)").setCellRenderer(new JListRenderer());
    tableauQ.getColumn("Question(s)").setCellEditor(new JListEditor());
    tableauQ.setRowHeight(70);
       
    // Paramètres de l'onglet Questionnaires
    
    tabbedPane.addTab("Questionnaires", panelQ);
    tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);  
    
    // Ajout des attributs au contenu de l'onglet Questionnaires    
    panelQl.setBorder(borderL);
    panelQl.add(new JScrollPane(tableauQ), BorderLayout.CENTER); 
    
    panelQg.setBorder(borderG);
    panelQg.add(pTitre);
    panelQg.add(pStitre);
    panelQg.add(pDateDebut);
    panelQg.add(pDateFin);
    panelQg.add(pMessageFin);
    panelQg.add(pQuestions);
    panelQg.add(triche);
    panelQg.add(pBoutons);
    
    panelQ.add(panelQl);
    panelQ.add(Box.createRigidArea(new Dimension(0,5)));
    panelQ.add(panelQg);

    
    
    
    
    // ONGLET SPORTIFS
    JComponent panelS = new JPanel();
   
    // Attributs
   
    // Paramètres de l'onglet Général
    panelS.setLayout(null);
    tabbedPane.addTab("Sportifs", panelS);
    panelS.setPreferredSize(new Dimension(720, 480));
    tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
   
    // Ajout des attributs au contenu de l'onglet Général
    
    
    // Ajoute les (panels) onglets au panel général -> permet l'affichage.
    this.add(tabbedPane, BorderLayout.CENTER); 
    
    // Le bouton pour QUITTER
    this.panelQuitter = new JPanel(new BorderLayout());
    this.panelQuitter1 = new JPanel();
    this.quitter = new JButton("Quitter");
    this.quitter.addActionListener(this);
    
    this.panelQuitter.add(this.panelQuitter1, BorderLayout.EAST); 
    this.panelQuitter1.add(this.quitter);
    this.add(panelQuitter, BorderLayout.SOUTH);
    
  }
  
  
  /*
   * Actions réalisées sur clic (quitter, créer, modifier, supprimer)
   */
  public void actionPerformed(ActionEvent e) {
    Object source = e.getSource();
    
    /**************************** QUITTER ********************************/
    if(source == this.quitter){
      this.setVisible(false);
      this.dispose();
    }
    
    
    /**************************** CREER ********************************/
    if(source == this.bCreer){

      // Attributs à ajouter :
      String titre;
      String stitre;
      String msgfin;
      Date dateD;
      Date dateF;
      
      // Initilisation : 
      titre = this.tTitre.getText();
      stitre = this.tStitre.getText();
      msgfin = this.tMessageFin.getText();
      dateD = (Date) dateDebut.getModel().getValue();
      dateF = (Date) dateFin.getModel().getValue();
      
      // Tests sur les attributs :
      
      
      // Ajout dans la liste :
      ArrayList<Question> questions = new ArrayList<Question>();
      questions.add(new Question("Bien ?", false));
      questions.add(new Question("Reveillé ?", true));
      questions.add(new Question("Debout ?", true));
      modeleQ.addQuestionnaire(new cda.Questionnaire(titre, stitre, dateD, 
          dateF, msgfin, questions));
    }

  }
    
  


  public static void main(String[] args) {
    Ihm ihm = new Ihm("Application Sportif");
    ihm.setVisible(true);
  }



  
  
}


/************************ FONCTIONS POUR LE CALENDRIER *************************/
@SuppressWarnings("serial")
class DateLabelFormatter extends AbstractFormatter {

  private String datePattern = "yyyy-MM-dd";
  private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

  public Object stringToValue(String text) throws ParseException {
    return dateFormatter.parseObject(text);
  }

  public String valueToString(Object value) throws ParseException {
    if (value != null) {
        Calendar cal = (Calendar) value;
        return dateFormatter.format(cal.getTime());
    }

    return "";
  }

}

