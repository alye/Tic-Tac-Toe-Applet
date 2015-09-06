import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

/*
 <APPLET
	CODE=Xn0.class
	HEIGHT=800
	WIDTH=800>
</APPLET>
 */


public class Xn0 extends Applet implements ActionListener
{
int a[]={0,0,0,0,0,0,0,0,0};
int player=1;
Button b[]=new Button[9];
Button reset=new Button("New Game");
Label n,p;


public void init()
{
         GridBagLayout gb = new GridBagLayout();
        GridBagConstraints gc=new GridBagConstraints();
        setLayout(gb);
        gc.weighty=1;
        gc.fill=GridBagConstraints.BOTH;

        gc.weightx=1;
        gc.gridwidth=GridBagConstraints.REMAINDER;
    Label l=new Label("Tic-Tac-Toe", Label.CENTER);
    gb.setConstraints(l,gc);
    Label m=new Label("-An Alizishaan Khatri creation", Label.RIGHT);
    gb.setConstraints(m,gc);
    add(l);
    add(m);

    gc.gridwidth=GridBagConstraints.HORIZONTAL;


    for(int i=0;i<9;i++)
    {
        b[i]=new Button(new String(""+(i+1)));
        if((i+1)%3==0)
        {
            gc.gridwidth=GridBagConstraints.REMAINDER;
            gb.setConstraints(b[i], gc);
            gc.gridwidth=GridBagConstraints.HORIZONTAL;
        }
        else
        {
            
            gb.setConstraints(b[i], gc);
        }


        add(b[i]);
        b[i].addActionListener(this);
    }

    n=new Label("",Label.CENTER);
    p=new Label("",Label.LEFT);
    reset.addActionListener(this);

    gc.gridwidth=GridBagConstraints.RELATIVE;
    
    gb.setConstraints(reset, gc);
    
    gc.gridwidth=GridBagConstraints.REMAINDER;
  
    gb.setConstraints(n,gc);
    gb.setConstraints(p, gc);

    add(n);
    add(reset);
    add(p);

    }

void done()
{
    for(int i=0;i<9;i++)
        b[i].removeActionListener(this);

}

int wincheck()
{
int k=0,j=0;


if ((a[0]==a[1]) && (a[1]==a[2]) && (a[0]!=0))
return (a[0]);

if ((a[0]==a[3]) && (a[3]==a[6]) && (a[0]!=0))
return (a[0]);

if ((a[0]==a[4]) && (a[4]==a[8]) && (a[0]!=0))
return (a[0]);

if ((a[2]==a[4]) && (a[4]==a[6]) && (a[2]!=0))
return (a[2]);

if ((a[2]==a[5]) && (a[5]==a[8]) && (a[2]!=0))
return (a[2]);

if ((a[6]==a[7]) && (a[7]==a[8]) && (a[6]!=0))
return (a[6]);

if ((a[1]==a[4]) && (a[4]==a[7]) && (a[1]!=0))
return (a[1]);

if ((a[3]==a[4]) && (a[4]==a[5]) && (a[3]!=0))
return (a[3]);

for (k=0;k<=8;k++)
if(a[k]==0)
    j=1;


if (j==1)
return (0);
else
return(2);
}

    public void actionPerformed(ActionEvent e)
    {
        Button btn=((Button)e.getSource());
        String s=btn.getLabel();

        if(s.equals("New Game"))
        {
            done();
            for(int i=0;i<9;i++)
            {
               a[i]=0;
               b[i].setLabel(""+(i+1));
               b[i].addActionListener(this);

            }
            player=1;
            p.setText("");
            n.setText("Its player 1's turn...");
            
        }
        else if(s.equals("X")||s.equals("O"))
        {
            p.setText("Invalid Move");
        }
        else
        {

            int i=Integer.parseInt(s);
            a[i-1]=player;

            if(player==1)
                b[i-1].setLabel("X");
            else if(player==-1)
                b[i-1].setLabel("O");

            player*=-1;
            p.setText("");
            
            

        }

    switch(wincheck())
    {
        case 1:n.setText("Player 1 Wins!!");
               done();
               break;

        case -1:n.setText("Player 2 Wins!!");
                done();
               break;

        case 2:n.setText("Its a Draw!");
                done();
               break;

        default: if(player==1)
                 n.setText("Player 1's Turn...");
                 else
                 n.setText("Player 2's Turn...");
                 
    }


    }

}


