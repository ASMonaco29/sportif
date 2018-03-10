package src;

import cda.ListeQuestionnaires;
import cda.Question;
import cda.Questionnaire;

import java.awt.Component;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.DefaultCellEditor;
import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;


@SuppressWarnings("serial")
public class ModelTableauQa extends AbstractTableModel {
  
  //private final List<Questionnaire> questionnaire = new ArrayList<Questionnaire>();
  private final ListeQuestionnaires questionnaires;

  private final String[] entetes = {"Titre", "Sous-titre", "Date debut", "Date fin", 
      "Message fin", "Question(s)"};
  
  @SuppressWarnings("rawtypes")
  private ArrayList<DefaultListModel> modl;
  private ArrayList<Question> questions;
  private ArrayList<Question> questions1;


  private Calendar cal;
  private Date dated1;
  private Date dated2;  
  private Date datef1;
  private Date datef2;
  
  @SuppressWarnings("rawtypes")
  private DefaultListModel dlm1;
  @SuppressWarnings("rawtypes")
  private DefaultListModel dlm2;
  
  @SuppressWarnings({ "rawtypes", "unchecked" })
  public ModelTableauQa() {
      super();
      
      this.questionnaires = new ListeQuestionnaires();
      this.questions = new ArrayList<Question>();
      this.questions1 = new ArrayList<Question>();
      this.modl = new ArrayList<DefaultListModel>();
      
      questions.add(new Question("Bien ?", false));
      questions.add(new Question("Reveillé ?", true));
      questions.add(new Question("Debout ?", true));
      questions1.add(new Question("Good ?", false));
      questions1.add(new Question("Awake ?", true));
      questions1.add(new Question("Wake up ?", true));
      
      dlm1 = new DefaultListModel();
      dlm1.addElement(questions.get(0));
      dlm1.addElement(questions.get(1));
      dlm1.addElement(questions.get(2));
      this.modl.add(dlm1);
      dlm2 = new DefaultListModel();
      dlm2.addElement(questions1.get(0));
      dlm2.addElement(questions1.get(1));
      dlm2.addElement(questions1.get(2));
      this.modl.add(dlm2);
      
      this.cal = Calendar.getInstance();
      cal.set(Calendar.YEAR, 2018);
      cal.set(Calendar.MONTH, 02);
      cal.set(Calendar.DAY_OF_MONTH, 28);
      dated1 = cal.getTime();
      
      cal.set(Calendar.YEAR, 2018);
      cal.set(Calendar.MONTH, 03);
      cal.set(Calendar.DAY_OF_MONTH, 01);
      dated2 = cal.getTime();
      
      cal.set(Calendar.YEAR, 2018);
      cal.set(Calendar.MONTH, 03);
      cal.set(Calendar.DAY_OF_MONTH, 28);
      datef1 = cal.getTime();
      
      cal.set(Calendar.YEAR, 2018);
      cal.set(Calendar.MONTH, 04);
      cal.set(Calendar.DAY_OF_MONTH, 01);
      datef2 = cal.getTime();
          
      questionnaires.addQuestionnaire("Bien-être", "Soin", dated1, datef1, 
          "Merci d'avoir répondu à ce questionnaire.", questions);
      questionnaires.addQuestionnaire("Santé", "Pour vous", dated1, datef1, 
          "Merci d'avoir répondu à ce questionnaire.", questions1);
      questionnaires.addQuestionnaire("Entrainement", "Quotidien", dated1, datef1, 
          "Merci d'avoir répondu à ce questionnaire.", questions1);
      questionnaires.addQuestionnaire("Conditions", "Tenace ?", dated2, datef2, 
          "Merci d'avoir répondu à ce questionnaire.", questions);
      questionnaires.addQuestionnaire("Sélections", "Travail", dated2, datef2, 
          "Merci d'avoir répondu à ce questionnaire.", questions1);
      questionnaires.addQuestionnaire("Bien-être", "Soin", dated1, datef1, 
          "Merci d'avoir répondu à ce questionnaire.", questions);
      questionnaires.addQuestionnaire("Santé", "Pour vous", dated1, datef1, 
          "Merci d'avoir répondu à ce questionnaire.", questions);
      questionnaires.addQuestionnaire("Entrainement", "Quotidien", dated1, datef1, 
          "Merci d'avoir répondu à ce questionnaire.", questions);
      questionnaires.addQuestionnaire("Conditions", "Tenace ?", dated2, datef2, 
          "Merci d'avoir répondu à ce questionnaire.", questions);
      questionnaires.addQuestionnaire("Sélections", "Travail", dated2, datef2, 
          "Merci d'avoir répondu à ce questionnaire.", questions);
      questionnaires.addQuestionnaire("Bien-être", "Soin", dated1, datef1, 
          "Merci d'avoir répondu à ce questionnaire.", questions);
      questionnaires.addQuestionnaire("Santé", "Pour vous", dated1, datef1, 
          "Merci d'avoir répondu à ce questionnaire.", questions);
      questionnaires.addQuestionnaire("Entrainement", "Quotidien", dated1, datef1, 
          "Merci d'avoir répondu à ce questionnaire.", questions);
      questionnaires.addQuestionnaire("Conditions", "Tenace ?", dated2, datef2, 
          "Merci d'avoir répondu à ce questionnaire.", questions);
      questionnaires.addQuestionnaire("Sélections", "Travail", dated2, datef2, 
          "Merci d'avoir répondu à ce questionnaire.", questions);
          
      
  }

  public int getRowCount() {
      return this.questionnaires.getSizeListQ();
  }

  public int getColumnCount() {
      return this.entetes.length;
  }

  public String getColumnName(int columnIndex) {
      return this.entetes[columnIndex];
  }

  public Object getValueAt(int rowIndex, int columnIndex) {
    switch(columnIndex){
        case 0:
            return this.questionnaires.getListQ().get(rowIndex).getTitre();
        case 1:
            return this.questionnaires.getListQ().get(rowIndex).getSstitre();
        case 2:
            return this.questionnaires.getListQ().get(rowIndex).getDateD();
        case 3:
            return this.questionnaires.getListQ().get(rowIndex).getDateF();
        case 4:
            return this.questionnaires.getListQ().get(rowIndex).getMessageFin();
        case 5:
            return this.modl.get(rowIndex%2);
        default:
            return null; // Ne devrait jamais arriver
    }
  }
    
  public void addQuestionnaire(Questionnaire quest) {
    this.questionnaires.addQuestionnaire(quest.getTitre(), quest.getSstitre(), quest.getDateD(), 
        quest.getDateF(), quest.getMessageFin(), quest.getquListe());

    fireTableRowsInserted(getRowCount()-1, getRowCount()-1);
  }
  
  public void removeQuestionnaire(int rowIndex) {
    this.questionnaires.supprQuestionnaire(this.questionnaires.getListQ().get(rowIndex));
    
    fireTableRowsDeleted(rowIndex, rowIndex);
  }
  
  
  @SuppressWarnings({ "unchecked", "rawtypes" })
  @Override
  public Class getColumnClass(int columnIndex){
      switch(columnIndex){
          case 2:
              return Date.class;
          case 3:
              return Date.class;
          default:
              return Object.class;
      }
  }
}



/* ************************************* CLASSE POUR JLIST  ******************** */
@SuppressWarnings("serial")
class JListRenderer extends JScrollPane implements TableCellRenderer {
  
  @SuppressWarnings("rawtypes")
  private JList list;
  
  @SuppressWarnings("rawtypes")
  public JListRenderer() {
    list = new JList();
    getViewport().add(list);
  }
  
  @SuppressWarnings({ "unchecked", "rawtypes" })
  public Component getTableCellRendererComponent(JTable table, Object value,
       boolean isSelected, boolean hasFocus, int row, int column) {
      
    if (isSelected) {
      setForeground(table.getSelectionForeground());
      setBackground(table.getSelectionBackground());
      list.setForeground(table.getSelectionForeground());
      list.setBackground(table.getSelectionBackground());
    } else {
      setForeground(table.getForeground());
      setBackground(table.getBackground());
      list.setForeground(table.getForeground());
      list.setBackground(table.getBackground());
    }
  
    list.setModel((DefaultListModel )value) ;
 
    return this;
  }
}
 



/* ************************************* CLASSE POUR JLIST  ******************** */
@SuppressWarnings("serial")
class JListEditor extends DefaultCellEditor {
   
  @SuppressWarnings("rawtypes")
  private JList list;
  private JScrollPane scrollpane;

  
   @SuppressWarnings({ "rawtypes" })
  public JListEditor() {
    super(new JCheckBox());
    
    scrollpane = new JScrollPane();
    list = new JList(); 
    scrollpane.getViewport().add(list);
   }
  
   @SuppressWarnings({ "unchecked", "rawtypes" })
  public Component getTableCellEditorComponent(JTable table, Object value,
                                   boolean isSelected, int row, int column) {
    list.setModel((DefaultListModel )value);
    
 
    return scrollpane;
  }
  
}