package compilador;

import static com.sun.awt.SecurityWarning.getSize;
import static com.sun.corba.se.impl.orbutil.CorbaResourceUtil.getText;
import static com.sun.org.apache.xerces.internal.util.DOMUtil.getDocument;
import static com.sun.org.apache.xerces.internal.util.DOMUtil.setVisible;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import static javafx.scene.layout.HBox.getMargin;
import static javafx.scene.layout.HBox.setMargin;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JEditorPane;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.KeyStroke;
import static javax.swing.UIManager.getFont;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.undo.UndoManager;
import static jdk.nashorn.internal.objects.NativeDebug.getClass;

/**
 * 
 * @author Jorge-Pc
 */
public class JTextField extends JEditorPane{

    private Dimension d = new Dimension(200,32);
    private String mostrar_texto = "";
    private Color phColor= new Color(0,0,0);
    private boolean HayQueMostrar = true;
    
    JPopupMenu menu = new JPopupMenu();
    JMenuItem copiar = new JMenuItem("Copiar", new ImageIcon(getClass().getResource("/icons/copiar.png")));
    JMenuItem pegar = new JMenuItem("Pegar", new ImageIcon(getClass().getResource("/icons/pegar.png")));
    JMenuItem cortar = new JMenuItem("Cortar", new ImageIcon(getClass().getResource("/icons/cortar.png")));
    
    UndoManager manager = new UndoManager();

    /** Constructor de clase */
    public JTextField(){
        super();
        setSize(d);
        setPreferredSize(d);
        setVisible(true);
        setMargin( new Insets(3,6,3,6));
        //atento a cambios 
        getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void removeUpdate(DocumentEvent e) {
                HayQueMostrar = (getText().length()>0) ? false:true ;
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                HayQueMostrar = false;
            }

            @Override
            public void changedUpdate(DocumentEvent de) {}

        });       
        
        menu.add(copiar);   menu.add(cortar);   menu.add(pegar);
        copiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                copy();
            }
        });
        cortar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                cut();
            }
        });
        pegar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                paste();
            }
        });
        
        getDocument().addUndoableEditListener(manager);
        Action deshacer = new Deshacer(manager);
        Action rehacer = new Rehacer(manager);
        
        registerKeyboardAction(deshacer, KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_MASK), JComponent.WHEN_FOCUSED);
        registerKeyboardAction(rehacer, KeyStroke.getKeyStroke(KeyEvent.VK_Y, InputEvent.CTRL_MASK), JComponent.WHEN_FOCUSED);
        
        setComponentPopupMenu(menu);
    }

    public void setPlaceholder(String placeholder)
    {
        this.mostrar_texto=placeholder;
    }

    public String getPlaceholder()
    {
        return mostrar_texto;
    }

    public Color getPhColor() {
        return phColor;
    }

    public void setPhColor(Color phColor) {
        this.phColor = phColor;
    }    

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //color de placeholder 
        g.setColor( new Color(phColor.getRed(),phColor.getGreen(),phColor.getBlue(),90));
        //dibuja texto
        g.drawString((HayQueMostrar)?mostrar_texto:"", getMargin().left, (getSize().height)/2 + getFont().getSize()/2 );
      }

}//JCTextField:end
