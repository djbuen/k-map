
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.Array;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicTabbedPaneUI.MouseHandler;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dave
 */
public class Kpanel extends JFrame{
    private  JLabel[] label;
    private  JPanel homepanel;
    private  JPanel panel2;
    private  JPanel panel3;
    private  JPanel panel1;
    private  JLabel label2;
    private  JPanel panel4;
    private  JLabel p1_label;
    private  qmOperations op;
    private  QM[] qm_elements;
    private  ArrayList<QM> set;
    private  int x,inc;
    public Kpanel(){
      super("KMAP");
      op = new qmOperations();
      GenerateSOP();

      label = new JLabel[16];
      homepanel = new JPanel();      
      MouseHandler ml = new MouseHandler();
     
      
      panel2 = new JPanel();
      panel2.add(homepanel);
      panel2.setLayout(new GridBagLayout());
      GridBagConstraints gbc = new GridBagConstraints();
      gbc.fill = GridBagConstraints.HORIZONTAL;
      label2 = new JLabel();
      JLabel w = new JLabel("CD  00");
      
      w.setFont(new Font("A", Font.BOLD, 30));
      JLabel u = new JLabel("      01");
      
      u.setFont(new Font("A", Font.BOLD, 32));
      JLabel y = new JLabel("      11");
     
      y.setFont(new Font("A", Font.BOLD, 32));
      JLabel z = new JLabel("      10");
     
      z.setFont(new Font("A", Font.BOLD, 32));
      panel2.setBorder(new EmptyBorder(new Insets(0, 0, 0, 0)));
      gbc.gridx = 0;
      gbc.gridy = 0;
      gbc.insets = new Insets(0, 50, 0, 0);
      panel2.add(w,gbc);
      gbc.gridx = 2;
      gbc.gridy = 0;
      
      panel2.add(u,gbc);
      gbc.gridx = 4;
      gbc.gridy = 0;
      panel2.add(y,gbc);
      gbc.gridx = 6;
      gbc.gridy = 0;
      panel2.add(z,gbc);
      add(panel2,BorderLayout.NORTH);

      panel1 = new JPanel();
      panel1.setBackground(Color.gray);
      panel1.setLayout(new GridLayout(4, 4));
      panel1.setPreferredSize(new Dimension(600,300)); 
      p1_label = new JLabel("Simplified Expression Here");
      

      panel3 = new JPanel();
      panel3.add(homepanel);
      panel3.add(p1_label);
      

      panel4 = new JPanel();
      panel4.add(homepanel);
      panel4.setLayout(new GridBagLayout());
      
      gbc.fill = GridBagConstraints.HORIZONTAL;
      
      w = new JLabel("AB  00");      
      w.setFont(new Font("A", Font.BOLD, 30));
      u = new JLabel("      01");     
      u.setFont(new Font("A", Font.BOLD, 32));
      y = new JLabel("      11");    
      y.setFont(new Font("A", Font.BOLD, 32));
      z = new JLabel("      10");     
      z.setFont(new Font("A", Font.BOLD, 32));
      panel4.setBorder(new EmptyBorder(new Insets(0, 0, 0, 0)));
      gbc.gridx = 0;
      gbc.gridy = 0;
      gbc.insets = new Insets(0, 0, 0, 0);
      panel4.add(w,gbc);
      gbc.gridx = 0;
      gbc.gridy = 1;
      gbc.insets = new Insets(30, 1, 1, 1);
      panel4.add(u,gbc);
      gbc.gridx = 0;
      gbc.gridy = 2;
      panel4.add(y,gbc);
      gbc.gridx = 0;
      gbc.gridy = 3;
      panel4.add(z,gbc);


      add(panel4,BorderLayout.WEST);
      add(panel3,BorderLayout.SOUTH);
      for(int i=0; i < 16; i++)
      {
      label[i] = new JLabel("0",(int) CENTER_ALIGNMENT);
      label[i].setFont(new Font("A", Font.BOLD, 80));
      label[i].setForeground(Color.blue);
      label[i].setBorder(LineBorder.createBlackLineBorder());
      label[i].addMouseListener(ml);
      }
      for(int i= 0,_x=2,_inc = 3; i< 16;i++)
      {    
         if(i < 8){
              if(i % _x == 0 && i != 0){
              panel1.add(label[i+1]);       
              panel1.add(label[i]);           
              _x = 2 * _inc;
              _inc += 2;
              i++;
              }
              else
              panel1.add(label[i]);  
         }
          else if(i >=8 && i < 12){
              if(i==10)
              {
              panel1.add(label[i+5]); // switch column 14 15 <- 15 14
              panel1.add(label[i+4]); // observation regarding Gridlayout, I found something strange behaviour after adding 15 14 then add 15 result would be 14 15
              i++;
              }
              else{              
              panel1.add(label[i+4]);             
              }
              
          }
          else
          {
              if(i == 14){
              panel1.add(label[i - 3]);
              panel1.add(label[i - 4]);
              i++;
              //
              
              // System.out.println("i-5 ::" + (i-5) + "i-4" + (i - 4) + "pilasdnfjaksdfh::::"+ label[i-3].getText());
              }
              else{
              panel1.add(label[i - 4]);
              System.out.println("else " + i);
              }
          }

      
        
        
      }
      
      panel1.setBorder(new EmptyBorder(new Insets(0, 0, 0, 0)));
      
      add(panel1,BorderLayout.CENTER);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      pack();
      setVisible(true);
    }

    public class MouseHandler extends MouseAdapter{
        int i;
        @Override
        public void mouseClicked(MouseEvent e) {
            for(i = 0 ; i < 16 ; i++){
                if(e.getSource() == label[i])
                    break;
                System.out.print("asdf"+label[i].getText());
            }
            if(i != 16)
            if(label[i].getText().equals("0"))
                label[i].setText("1");
            else
                label[i].setText("0");
      
            InitSet();
            for(i = 0 ; i < 16 ; i++)
            {
                if(label[i].getText().equals("1"))
                {
                    op.additem(set.get(2), qm_elements[i].product);
                    op.Qrec(set, 2);
                   
                }

             }
             
             p1_label.setText(op.CollectVar(set));
             
            
                for(QM trav = set.get(2).next; trav != null; trav = trav.next){
                        System.out.print("sop::" + trav.product[0] + trav.product[1] + trav.product[2]);
                        
         
         
        }
    }
    
 }


    public void GenerateSOP(){
       qm_elements = new QM[16];
        int left,j;
        for(int i = 0 ; i < 16; i++)
        {
            qm_elements[i] = new QM();
            for(j = 4,left = i; j > 0 ; --j)
            {
                qm_elements[i].product[j-1] = left % 2;
                left /= 2;
            }
            for(j = 0; j < 4; ++j)
            {
                System.out.print(qm_elements[i].product[j]);
            }
            System.out.println("");
        }
    }

    public void InitSet(){
        set = new ArrayList<QM>();
        for(int i = 0 ; i < 3; i++)
            set.add(new QM());
    }
}

