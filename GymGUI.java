import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.io.FileWriter;
import java.io.File;
import java.io.FileReader;
import javax.swing.JScrollPane;

public class GymGUI implements ActionListener
{
    ArrayList<GymMember> array = new ArrayList<GymMember>();
    public static void main(String[]args)
    {
        new GymGUI();
    }
    JFrame option, regfr, prefr;
    JLabel labelid, labelname, labellocation, labeldob, labelemail,
    labelphone, labelgender, labelplan, labelmembershipsd,
    labelreferral, labelpaid, labelremoval,labeltrainer, labelprice,
    labeldiscount,title,regular,premium;

    JLabel plabelid, plabelname, plabellocation, plabeldob, plabelemail,
    plabelphone, plabelgender, plabelplan, plabelmembershipsd,
    plabelreferral, plabelpaid, plabelremoval,plabeltrainer, plabelprice,
    plabeldiscount, plablecalculatediscount;

    JTextField tfid,tflocation,tfemail, tfpaid, tfname, tfphone, tfreferral,tfremoval;

    JTextField tfidp,tflocationp,tfemailp, tfpaidp, tfnamep, tfphonep, tfreferralp,tfremovalp, tftrainerp;

    JComboBox comboDobYr,comboDobMonth,comboDobDate, plancb, comboMsYr,comboMsMonth, comboMsDay;
    JRadioButton malerd, femalerd;
    ButtonGroup grp, bg;

    JComboBox pcomboDobYr,pcomboDobMonth,pcomboDobDate, pplancb, pcomboMsYr,pcomboMsMonth, pcomboMsDay;
    JRadioButton pmalerd, pfemalerd;

    JButton pre,reg;
    JButton addreg, addpre, activate, deactivate, attendance,revert, clear, display;
    JButton pactivate, pdeactivate, pattendance,prevert, pclear, pdisplay, pcalculatediscount, btnUpgrade;

    JButton RSave, RRead;
    JButton PSave, PRead;
    JButton CalcDiscount, PayDue;
    JFrame displayframe;
    JTextArea displayta;
    public GymGUI()
    {
        //option gui
        option = new JFrame("");
        title = new JLabel("Are you regular or premium member");
        reg = new JButton("Regular Member");
        pre = new JButton("Premium Member");

        title.setBounds(130,5,250,30);
        reg.setBounds(50,50,200,60);
        pre.setBounds(300,50,200,60);

        option.add(title);
        option.add(reg);
        option.add(pre);

        option.setLayout(null);
        option.setVisible(true);
        option.setSize(550,200);

        //application member gui
        regfr = new JFrame("");

        regular = new JLabel("Regular Membership");
        RSave = new JButton("Save");
        RSave.setBounds(200,15,100,50);
        RRead = new JButton("Read");
        RRead.setBounds(400,15,100,50);
        regfr.add(RSave);
        regfr.add(RRead);

        labelid = new JLabel("ID");
        labelname = new JLabel("Name");
        labellocation = new JLabel("Location");
        labeldob = new JLabel("DOB");
        labelemail = new JLabel("Email");
        labelphone = new JLabel("Phone");
        labelgender = new JLabel("Gender");
        labelplan = new JLabel("Plan");
        labelmembershipsd = new JLabel("Membership Start Date");
        labelreferral = new JLabel("Referral Source");
        labelpaid = new JLabel("Paid Amount");
        labelremoval = new JLabel("Removal Reason");
        labeltrainer = new JLabel("Trainer's Name");
        labelprice = new JLabel("Plan Price");
        labeldiscount = new JLabel("Discount Amount");

        tfid = new JTextField();
        tflocation = new JTextField();
        tfemail = new JTextField();
        tfpaid = new JTextField();
        tfname = new JTextField();
        tfphone = new JTextField();
        tfreferral = new JTextField();
        tfremoval = new JTextField();

        String y[]={"2010","2011","2012","2013","2014","2015","2016"};
        String m[]={"1","2","3","4","5","6","7","8","9","10","11","12"};
        String d[]={"1","2","3","4","5","6","7","8","9","10","11","12",
                "13","14","15","16","17","18","19","20","21","22","23","24",
                "25","26","27","28","29","30","31"};
        String p[]= {"Basic","Standard","Deluxe"};
        comboDobYr = new JComboBox(y);
        comboDobMonth = new JComboBox(m);
        comboDobDate = new JComboBox(d);
        plancb = new JComboBox(p);
        comboMsYr = new JComboBox(y);
        comboMsMonth = new JComboBox(m);
        comboMsDay = new JComboBox(d);

        malerd = new JRadioButton("Male");
        femalerd = new JRadioButton("Female");
        grp = new ButtonGroup();

        addreg = new JButton("Add Regular Member");
        addpre = new JButton("Add Premium Member");
        activate  = new JButton("Activate Membership");
        deactivate = new JButton("Deactivate Membership");
        attendance = new JButton("Mark Attendance");
        revert = new JButton("Revert Membership");
        clear = new JButton("Clear");
        display = new JButton("Display");
        btnUpgrade = new JButton("Upgrade");
        btnUpgrade.setBounds(50,600,100,15);

        regular.setBounds(15,15,250,50);

        labelid.setBounds(50,110,100,15);
        labeldob.setBounds(50,190,100,15);
        labelemail.setBounds(50,260,100,15);
        labelgender.setBounds(50,340,100,15);
        labelmembershipsd.setBounds(50,420,150,15);
        labelpaid.setBounds(50,500,100,15);

        labelname.setBounds(550,110,100,15);
        labellocation.setBounds(550,190,100,15);
        labelphone.setBounds(550,260,100,15);
        labelplan.setBounds(550,340,100,15);
        labelreferral.setBounds(550,420,100,15);
        labelremoval.setBounds(550,500,150,15);

        addreg.setBounds(50,620,180,40);
        activate.setBounds(370,620,180,40);
        deactivate.setBounds(670,620,180,40);
        attendance.setBounds(50,680,180,40);
        revert.setBounds(370,680,180,40);
        clear.setBounds(670,680,180,40);
        display.setBounds(50,740,180,40);

        tfid.setBounds(48,140,300,20);

        tfemail.setBounds(48,290,300,20);
        tfpaid.setBounds(48,530,300,20);

        tfname.setBounds(548,140,300,20);
        tflocation.setBounds(548,210,300,20);
        tfphone.setBounds(548,290,300,20);
        tfreferral.setBounds(548,440,300,20);
        tfremoval.setBounds(548,530,300,20);

        malerd.setBounds(48,370,100,15);
        femalerd.setBounds(150,370,100,15);

        plancb.setBounds(548,360,300,30);
        comboDobYr.setBounds(48,210,100,30);
        comboDobMonth.setBounds(148,210,100,30);
        comboDobDate.setBounds(248,210,100,30);
        comboMsYr.setBounds(48,440,100,30);
        comboMsMonth.setBounds(148,440,100,30);
        comboMsDay.setBounds(248,440,100,30);

        regfr.add(regular);
        regfr.add(labelid);
        regfr.add(labelname);
        regfr.add(labellocation);
        regfr.add(labelemail);
        regfr.add(labelphone);
        regfr.add(labelgender);
        regfr.add(labelplan);
        regfr.add(labeldob);
        regfr.add(labelmembershipsd);
        regfr.add(labelreferral);
        regfr.add(labelpaid);
        regfr.add(labelremoval);

        regfr.add(labelprice);
        regfr.add(labeldiscount);
        regfr.add(tfid);
        regfr.add(tflocation);
        regfr.add(tfemail);
        regfr.add(tfpaid);
        regfr.add(tfname);
        regfr.add(tfphone);
        regfr.add(tfreferral);
        regfr.add(tfremoval);
        regfr.add(btnUpgrade);

        regfr.add(malerd);
        regfr.add(femalerd);
        regfr.add(comboDobYr);
        regfr.add(comboDobMonth);
        regfr.add(comboDobDate);
        regfr.add(plancb);
        regfr.add(comboMsYr);
        regfr.add(comboMsMonth);
        regfr.add(comboMsDay);
        regfr.add(addreg);
        regfr.add(attendance);
        regfr.add(activate);
        regfr.add(deactivate);
        regfr.add(clear);
        regfr.add(display);
        regfr.add(revert);
        grp.add(malerd);
        grp.add(femalerd);

        regfr.setLayout(null);
        regfr.setVisible(false);
        regfr.setSize(900,1000);

        //premium frame

        prefr = new JFrame("");
        premium = new JLabel("Premium Membership");
        plabelid = new JLabel("ID");
        plabelname = new JLabel("Name");
        plabellocation = new JLabel("Location");
        plabeldob = new JLabel("DOB");
        plabelemail = new JLabel("Email");
        plabelphone = new JLabel("Phone");
        plabelgender = new JLabel("Gender");
        plabelplan = new JLabel("Plan");
        plabelmembershipsd = new JLabel("Membership Start Date");
        plabelreferral = new JLabel("Referral Source");
        plabelpaid = new JLabel("Paid Amount");
        plabelremoval = new JLabel("Removal Reason");
        plabeltrainer = new JLabel("Trainer's Name");
        plabelprice = new JLabel("Plan Price");
        plabeldiscount = new JLabel("Discount Amount");

        pcalculatediscount = new JButton("Calculate Discount");
        PayDue = new JButton("Pay Due Amount");
        PayDue.setBounds(670,740,180,40);
        prefr.add(PayDue);

        tfidp = new JTextField();
        tflocationp = new JTextField();
        tfemailp = new JTextField();
        tfpaidp = new JTextField();
        tfnamep = new JTextField();
        tfphonep = new JTextField();
        tfreferralp = new JTextField();
        tfremovalp = new JTextField();
        tftrainerp = new JTextField();

        pcomboDobYr = new JComboBox(y);
        pcomboDobMonth = new JComboBox(m);
        pcomboDobDate = new JComboBox(d);

        pcomboMsYr = new JComboBox(y);
        pcomboMsMonth = new JComboBox(m);
        pcomboMsDay = new JComboBox(d);

        pmalerd = new JRadioButton("Male");
        pfemalerd = new JRadioButton("Female");
        bg = new ButtonGroup();

        addpre = new JButton("Add Premium Member");
        pactivate  = new JButton("Activate Membership");
        pdeactivate = new JButton("Deactivate Membership");
        pattendance = new JButton("Mark Attendance");
        prevert = new JButton("Revert Membership");
        pclear = new JButton("Clear");
        pdisplay = new JButton("Display");
        pcalculatediscount = new JButton("Calculate Discount");

        premium.setBounds(15,15,250,50);
        plabelid.setBounds(50,110,100,15);
        plabellocation.setBounds(550,190,100,15);
        plabelemail.setBounds(50,260,100,15);
        plabelgender.setBounds(50,340,100,15);
        plabelmembershipsd.setBounds(50,420,150,15);
        plabelpaid.setBounds(50,500,100,15);

        plabelname.setBounds(550,110,100,15);
        plabeldob.setBounds(50,190,100,15);
        plabelphone.setBounds(550,260,100,15);
        labeltrainer.setBounds(550,340,150,15);
        plabelreferral.setBounds(550,420,100,15);
        plabelremoval.setBounds(550,500,150,15);

        addpre.setBounds(50,620,180,40);
        pactivate.setBounds(370,620,180,40);
        pdeactivate.setBounds(670,620,180,40);
        pattendance.setBounds(50,680,180,40);
        prevert.setBounds(370,680,180,40);
        pclear.setBounds(670,680,180,40);
        pdisplay.setBounds(50,740,180,40);

        tfidp.setBounds(48,140,300,20);
        tfphonep.setBounds(548,290,300,20);
        tfemailp.setBounds(48,300,300,20);
        tfpaidp.setBounds(48,530,300,20);

        tfnamep.setBounds(548,140,300,20);
        tflocationp.setBounds(548,210,300,20);
        tfreferralp.setBounds(548,440,300,20);
        tfremovalp.setBounds(548,530,300,20);

        tftrainerp.setBounds(548,360,300,20);

        pmalerd.setBounds(48,370,100,15);
        pfemalerd.setBounds(150,370,100,15);

        pcomboDobYr.setBounds(48,210,100,30);
        pcomboDobMonth.setBounds(148,210,100,30);
        pcomboDobDate.setBounds(248,210,100,30);
        pcomboMsYr.setBounds(48,440,100,30);
        pcomboMsMonth.setBounds(148,440,100,30);
        pcomboMsDay.setBounds(248,440,100,30);

        PSave = new JButton("Save");
        PSave.setBounds(200,15,100,50);
        PRead = new JButton("Read");
        PRead.setBounds(400,15,100,50);
        pcalculatediscount.setBounds(370,740,180,40);

        prefr.add(pcalculatediscount);
        prefr.add(premium);
        prefr.add(PSave);
        prefr.add(PRead);
        prefr.add(plabelid);
        prefr.add(plabelname);
        prefr.add(plabellocation);
        prefr.add(plabelemail);
        prefr.add(plabelgender);
        prefr.add(plabeldob);
        prefr.add(plabelphone);
        prefr.add(plabelplan);
        prefr.add(plabelmembershipsd);
        prefr.add(plabelreferral);
        prefr.add(plabelpaid);
        prefr.add(plabelremoval);
        prefr.add(labeltrainer);
        prefr.add(plabelprice);
        prefr.add(plabeldiscount);
        prefr.add(tfidp);
        prefr.add(tflocationp);
        prefr.add(tfemailp);
        prefr.add(tfpaidp);

        prefr.add(tfnamep);
        prefr.add(tfphonep);
        prefr.add(tfreferralp);
        prefr.add(tfremovalp);

        prefr.add(tftrainerp);
        prefr.add(pmalerd);
        prefr.add(pfemalerd);
        prefr.add(pcomboDobYr);
        prefr.add(pcomboDobMonth);
        prefr.add(pcomboDobDate);

        prefr.add(pcomboMsYr);
        prefr.add(pcomboMsMonth);
        prefr.add(pcomboMsDay);
        prefr.add(addpre);
        prefr.add(pattendance);
        prefr.add(pactivate);
        prefr.add(pdeactivate);
        prefr.add(pclear);
        prefr.add(pdisplay);
        prefr.add(prevert);

        bg.add(pmalerd);
        bg.add(pfemalerd);

        reg.addActionListener(this);
        pre.addActionListener(this);
        addreg.addActionListener(this);
        addpre.addActionListener(this);
        activate.addActionListener(this);
        deactivate.addActionListener(this);
        attendance.addActionListener(this);
        revert.addActionListener(this);
        clear.addActionListener(this);
        display.addActionListener(this);
        pcalculatediscount.addActionListener(this);
        PSave.addActionListener(this);
        RSave.addActionListener(this);
        PRead.addActionListener(this);
        RRead.addActionListener(this);
        PayDue.addActionListener(this);
        pactivate.addActionListener(this);
        pdeactivate.addActionListener(this);
        pattendance.addActionListener(this);
        prevert.addActionListener(this);
        pclear.addActionListener(this);
        pdisplay.addActionListener(this);

        prefr.setLayout(null);
        prefr.setVisible(false);
        prefr.setSize(900,1000);

        displayframe = new JFrame();
        displayta = new JTextArea();
        JScrollPane scrollDisplay = new JScrollPane(displayta);
        
        scrollDisplay.setBounds(50,15,500,500);
        displayframe.add(scrollDisplay);
        displayframe.setLayout(null);
        displayframe.setVisible(false);
        displayframe.setSize(600,600);

    }

    @Override
    public void actionPerformed(ActionEvent ae)
    {

        if(ae.getSource()==reg)
        {
            regfr.setVisible(true);
            prefr.setVisible(false);
        }
        else if(ae.getSource()==pre)
        {
            prefr.setVisible(true);
            regfr.setVisible(false);
        }
        else if(ae.getSource()==addreg)
        {
            if(tfid.getText().isEmpty()|| tflocation.getText().isEmpty()|| tfemail.getText().isEmpty()||
            tfname.getText().isEmpty()||tfphone.getText().isEmpty()||tfreferral.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(regfr,"please fill in the application");
            }
            else
            {
                try{
                    int regid = Integer.parseInt(tfid.getText());
                    String regLocation = tflocation.getText();
                    String regEmail = tfemail.getText();
                    String regName = tfname.getText();
                    String regPhone = tfphone.getText();
                    String regReferral = tfreferral.getText();
                    String regGender="";
                    if(malerd.isSelected())
                    {
                        regGender="male";
                    }
                    else if(femalerd.isSelected())
                    {
                        regGender="female";
                    }
                    String year= (String) comboDobYr.getSelectedItem();
                    String month= (String) comboDobMonth.getSelectedItem(); 
                    String date= (String) comboDobDate.getSelectedItem();
                    String regDob= date+"-"+month+"-"+year;
                    String myear= (String) comboMsYr.getSelectedItem();
                    String mmonth= (String) comboMsMonth.getSelectedItem(); 
                    String mdate= (String) comboMsDay.getSelectedItem();
                    String regMembershipsd= mdate+"-"+mmonth+"-"+myear;

                    if(array.isEmpty())
                    {  
                        RegularMember regobj = new RegularMember(regid,regName,regLocation,regPhone,regEmail,
                                regGender,regDob, regMembershipsd, regReferral);
                        array.add(regobj);
                        JOptionPane.showMessageDialog(regfr,"Regular Member added");
                    }
                    else
                    {
                        boolean idexits=false;
                        for(GymMember mem : array)
                        {

                            if(mem.getId()==regid) 
                            {
                                idexits=true;
                                break;
                            }
                        }
                        if(idexits)
                        {
                            JOptionPane.showMessageDialog(regfr,"please choose another ID.");
                        }
                        else
                        {
                            RegularMember regobj = new RegularMember(regid,regName,regLocation,regPhone,regEmail,
                                    regGender,regDob, regMembershipsd, regReferral);
                            array.add(regobj);
                            JOptionPane.showMessageDialog(regfr,"Regular Member added");
                        }
                    }
                }
                catch(NumberFormatException ex)
                {
                    JOptionPane.showMessageDialog(regfr,"Please input number for ID","Error",JOptionPane.WARNING_MESSAGE);
                }
            }
        }

        else if(ae.getSource()==attendance)
        {
            if(tfid.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(regfr,"ID found empty");
            }
            else
            {
                try{
                    int regid=Integer.parseInt(tfid.getText());
                    boolean idexits=false;
                    GymMember memberExists = null;
                    for(GymMember member : array)
                    {

                        if(member.getId()==regid)
                        {
                            idexits=true;
                            memberExists  = member;
                            break;
                        }
                    }
                    if(idexits)
                    {
                        if(memberExists.getActiveStatus()){
                            memberExists.markAttendance();
                            JOptionPane.showMessageDialog(regfr,"Attendance marked");
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(regfr,"member is not activate");
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(regfr, "ID not found","Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                catch(NumberFormatException ex)
                {
                    JOptionPane.showMessageDialog(regfr,"Please input number for ID");
                }
            }
        }

        else if(ae.getSource()==activate)
        {
            if(tfid.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(regfr,"ID found empty");
            }
            else
            {
                try{
                    int regid=Integer.parseInt(tfid.getText());
                    boolean idexits=false;
                    GymMember memberExists = null;
                    for(GymMember member : array)
                    {
                        if(member.getId()==regid)
                        {
                            idexits=true;
                            memberExists  = member;
                            break;
                        }
                    }
                    if(idexits)
                    {
                        if(memberExists.getActiveStatus()){
                            JOptionPane.showMessageDialog(regfr,"Membership is already activated","Activated",JOptionPane.INFORMATION_MESSAGE);
                        }
                        else
                        {
                            memberExists.activateMembership();
                            JOptionPane.showMessageDialog(regfr,"Membership activated");

                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(regfr, "ID not found");
                    }
                }
                catch(NumberFormatException ex)
                {
                    JOptionPane.showMessageDialog(regfr,"Please input number for ID");
                }
            }

        }

        else if(ae.getSource()==deactivate)
        {
            if(tfid.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(regfr,"ID found empty");
            }
            else
            {
                try{
                    int regid=Integer.parseInt(tfid.getText());
                    boolean idexits=false;
                    GymMember memberExists = null;
                    for(GymMember member : array)
                    {

                        if(member.getId()==regid) 
                        {
                            idexits=true;
                            memberExists  = member;
                            break;
                        }
                    }
                    if(idexits)
                    {
                        if(memberExists.getActiveStatus()==false){
                            JOptionPane.showMessageDialog(regfr,"Membership is already deactivated");
                        }
                        else
                        {
                            memberExists.deactivateMembership();
                            JOptionPane.showMessageDialog(regfr,"Membership deactivated");
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(regfr, "ID not found");
                    }
                }
                catch(NumberFormatException ex)
                {
                    JOptionPane.showMessageDialog(regfr,"Please input number for ID");
                }
            }
        }

        else if(ae.getSource()==revert)
        {
            if(tfid.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(regfr,"ID found empty");
            }
            else if(tfremoval.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(regfr,"please fill in the removal reason");
            }
            else
            {
                try{
                    int regid=Integer.parseInt(tfid.getText());
                    String regRemoval=tfremoval.getText();
                    boolean idexits=false;
                    GymMember memberExists = null;
                    for(GymMember member : array)
                    {
                        if(member.getId()==regid)
                        {
                            idexits=true;
                            memberExists  = member;
                            break;
                        }
                    }
                    if(idexits)
                    {
                        memberExists.resetMembership();
                        JOptionPane.showMessageDialog(regfr,"Membership Reset");
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(regfr, "ID not found");
                    }
                }
                catch(NumberFormatException ex)
                {
                    JOptionPane.showMessageDialog(regfr,"Please input number for ID");
                }
            }
        }

       
        else if(ae.getSource()==display) 
        {
            displayframe.setVisible(true);
            displayta.setText("");
            if(array.isEmpty())
            {

                displayta.append("NO MEMBER REGISTERED!!!");
            }
            else
            {
                displayta.append("\nREGULAR MEMBERS: \n\n ");
                boolean memberExistence=false;
                
                for(GymMember member : array)
                {
                    if(member instanceof RegularMember)
                    {
                        memberExistence= true;
                        break;
                    }
                }
                if(memberExistence)
                {
                    for(GymMember member:array)
                    {
                        if(member instanceof RegularMember)
                        {
                            RegularMember regular = (RegularMember) member;
                            displayta.append("\nMember ID: "+regular.getId()+"\n");
                            displayta.append("Name: "+regular.getName()+"\n");
                            displayta.append("Location: "+regular.getLocation()+"\n");
                            displayta.append("Email: "+regular.getEmail()+"\n");
                            displayta.append("Phone: "+regular.getPhone()+"\n");
                            displayta.append("Date of Birth: "+regular.getDOB()+"\n");
                            displayta.append("Gender: "+regular.getGender()+"\n");
                            displayta.append("Plan: "+regular.getPlan()+"\n");
                            displayta.append("Price: "+regular.getPrice()+"\n");
                            displayta.append("Membership Start Date: "+regular.getMembershipStartDate()+"\n");
                            displayta.append("Attendance: "+regular.getAttendance()+"\n");
                            displayta.append("Loyalty Points: "+regular.getLoyaltyPoints()+"\n");
                            displayta.append("Active Status: "+regular.getActiveStatus()+"\n");
                            if(regular.getRemovalReason()!="")
                            {
                                displayta.append("Removal Reason: "+regular.getRemovalReason()+"\n");
                            }
                            displayta.append("-------------------------------------------------------------------------------------");
                        }
                    }
                }
                else
                {
                    displayta.append("NO REGULAR MEMBER REGISTERED!!!");
                }
            }
        }

        else if (ae.getSource()==revert){
            if(tfid.getText().isEmpty()){
                JOptionPane.showMessageDialog(regfr,"Please input value for Member ID");

            }
            else if (tfremoval.getText().isEmpty()){
                JOptionPane.showMessageDialog(regfr, "Please input a valid removal reason!");

            }
            else {                            
                try{
                    int memId = Integer.parseInt(tfid.getText());
                    String removalReason = tfremoval.getText();
                    boolean isMemberFound = false;
                    RegularMember matchedMember = null;
                    for(GymMember member : array) {
                        if(member instanceof RegularMember) {
                            RegularMember regular = (RegularMember) member;
                            if (regular.getId() == memId) {
                                isMemberFound = true;
                                matchedMember = regular;
                                break;
                            }
                        }
                    }
                    if (isMemberFound) {
                        matchedMember.revertRegularMember(removalReason);
                        JOptionPane.showMessageDialog(regfr,"Successfully Reverted Member Status for: "+matchedMember.getName(),"Success", JOptionPane.INFORMATION_MESSAGE); 
                    }
                    else {
                        JOptionPane.showMessageDialog(regfr,"Member with this ID does not exist!","ERROR",JOptionPane.ERROR_MESSAGE);

                    }
                }
                catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(regfr,"ID can only have number values!","ERROR", JOptionPane.WARNING_MESSAGE);                               
                }
            }
        }

    
   
        else if(ae.getSource()==clear || ae.getSource()==pclear)
        {
            tfid.setText("");
            tflocation.setText("");
            tfemail.setText("");
            tfpaid.setText("");
            tfname.setText("");
            tfphone.setText("");
            tfreferral.setText("");
            tfremoval.setText("");

            tfidp.setText("");
            tflocationp.setText("");
            tfemailp.setText("");
            tfpaidp.setText("");

            tfnamep.setText("");
            tfphonep.setText("");
            tfreferralp.setText("");
            tfremovalp.setText("");

            tftrainerp.setText("");

            comboDobMonth.setSelectedItem("January");
            comboDobYr.setSelectedItem("2006");
            comboDobDate.setSelectedItem("1");
            comboMsDay.setSelectedItem("1");
            comboMsMonth.setSelectedItem("January");
            comboMsYr.setSelectedItem("2006");

            plancb.setSelectedItem("basic");
        }

        else if(ae.getSource()==addpre)
        {
            try{
                if(tfidp.getText().isEmpty()|| tflocationp.getText().isEmpty()|| tfemailp.getText().isEmpty()||
                tfnamep.getText().isEmpty()||tfphonep.getText().isEmpty()||tfreferralp.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(prefr,"please fill in the application");
                }
                else
                {
                    int preid = Integer.parseInt(tfidp.getText());
                    String preLocation = tflocationp.getText();
                    String preEmail = tfemailp.getText();
                    String preName = tfnamep.getText();
                    String prePhone = tfphonep.getText();
                    String preTrainer = tftrainerp.getText();
                    String preGender="";
                    if(pmalerd.isSelected())
                    {
                        preGender="male";
                    }
                    else if(pfemalerd.isSelected())
                    {
                        preGender="female";
                    }
                    String year= (String) pcomboDobYr.getSelectedItem();
                    String month= (String) pcomboDobMonth.getSelectedItem(); 
                    String date= (String) pcomboDobDate.getSelectedItem();
                    String preDob= date+"-"+month+"-"+year;
                    String myear= (String) pcomboMsYr.getSelectedItem();
                    String mmonth= (String) pcomboMsMonth.getSelectedItem(); 
                    String mdate= (String) pcomboMsDay.getSelectedItem();
                    String preMembershipsd= mdate+"-"+mmonth+"-"+myear;

                    if(array.isEmpty())
                    {
                        //creating object
                        PremiumMember preobj = new PremiumMember(preid,preName,preLocation,prePhone,preEmail,
                                preGender,preDob, preMembershipsd, preTrainer);
                        array.add(preobj);
                        JOptionPane.showMessageDialog(prefr,"Premium Member added");
                    }
                    else
                    {
                        boolean idexits=false;
                        for(GymMember mem : array)
                        {

                            if(mem.getId()==preid) 
                            {
                                idexits=true;
                                break;
                            }
                        }
                        if(idexits)
                        {
                            JOptionPane.showMessageDialog(prefr,"please choose another ID.","Duplication",JOptionPane.ERROR_MESSAGE);
                        }
                        else
                        {
                            PremiumMember preobj = new PremiumMember(preid,preName,preLocation,prePhone,preEmail,
                                    preGender,preDob, preMembershipsd, preTrainer);
                            array.add(preobj);
                            JOptionPane.showMessageDialog(prefr,"Premium Member added");
                        }
                    }
                }
            }
            catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(prefr,"Please input number for ID","Error",JOptionPane.WARNING_MESSAGE);
            }
        }
        else if (ae.getSource()==pattendance)
        {
            if(tfidp.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(prefr,"ID found empty");
            }
            else
            {
                try{
                    int preid=Integer.parseInt(tfidp.getText());
                    boolean idexits=false;
                    GymMember memberExists = null;
                    for(GymMember member : array)
                    {
                        if(member.getId()==preid)
                        {
                            idexits=true;
                            memberExists  = member;
                            break;
                        }
                    }
                    if(idexits)
                    {
                        if(memberExists.getActiveStatus()){
                            memberExists.markAttendance(); 
                            JOptionPane.showMessageDialog(prefr,"Attendance marked","Attendance",JOptionPane.INFORMATION_MESSAGE);
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(prefr,"member is not activate","Attendance",JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(prefr, "ID not found","Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(prefr,"Please input number for ID","Error",JOptionPane.WARNING_MESSAGE);
                }
            }
        }
        else if(ae.getSource()==prevert)
        {
            if(tfidp.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(prefr,"ID found empty");
            }
            else if(tfremovalp.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(prefr,"please fill in the removal reason");
            }
            else
            {
                try{
                    int preid=Integer.parseInt(tfidp.getText());
                    String preRemoval=tfremovalp.getText();
                    boolean idexits=false;
                    GymMember memberExists = null;
                    for(GymMember member : array)
                    {
                        if(member.getId()==preid)
                        {
                            idexits=true;
                            memberExists  = member;
                            break;
                        }
                    }
                    if(idexits)
                    {
                        memberExists.resetMembership();
                        JOptionPane.showMessageDialog(prefr,"Membership Reset","Reset",JOptionPane.INFORMATION_MESSAGE);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(prefr, "ID not found","Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(prefr,"Please input number for ID","Error",JOptionPane.WARNING_MESSAGE);
                }
            }
        }
        else if(ae.getSource()==pactivate)
        {
            if(tfidp.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(prefr,"ID found empty");
            }
            else
            {
                try{
                    int preid=Integer.parseInt(tfidp.getText());
                    boolean idexits=false;
                    GymMember memberExists = null;
                    for(GymMember member : array)
                    {

                        if(member.getId()==preid) 
                        {
                            idexits=true;
                            memberExists  = member;
                            break;
                        }
                    }
                    if(idexits)
                    {
                        if(memberExists.getActiveStatus()){
                            JOptionPane.showMessageDialog(prefr,"Membership is already activated","Activated",JOptionPane.INFORMATION_MESSAGE);
                        }
                        else
                        {
                            memberExists.activateMembership();
                            JOptionPane.showMessageDialog(prefr,"Membership activated","Activated",JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(prefr, "ID not found","Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                catch(NumberFormatException ex)
                {
                    JOptionPane.showMessageDialog(prefr,"Please input number for ID","Error",JOptionPane.WARNING_MESSAGE);
                }
            }
        }
        else if(ae.getSource()==pdeactivate)
        {
            if(tfidp.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(prefr,"ID found empty");
            }
            else
            {
                try{
                    int preid = Integer.parseInt(tfidp.getText());
                    boolean idexits=false;
                    GymMember memberExists = null;
                    for(GymMember member : array)
                    {

                        if(member.getId()==preid) 
                        {
                            idexits=true;
                            memberExists  = member;
                            break;
                        }
                    }
                    if(idexits)
                    {
                        if(memberExists.getActiveStatus()==false){
                            JOptionPane.showMessageDialog(prefr,"Membership is already deactivated","Deactivated",JOptionPane.INFORMATION_MESSAGE);
                        }
                        else
                        {
                            memberExists.deactivateMembership();
                            JOptionPane.showMessageDialog(prefr,"Membership deactivated","Deactivated",JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(prefr, "ID not found","Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(prefr,"Please input number for ID","Error",JOptionPane.WARNING_MESSAGE);
                }
            }
        }
        else if(ae.getSource()==pdisplay)
        {
            displayframe.setVisible(true);
            displayta.setText("");
            if(array.isEmpty())
            {
                displayta.append("NO MEMBER REGISTERED!!!");
            }
            else
            {
                displayta.append("\nPREMIUM MEMBERS: \n\n ");
                boolean memberExistence=false;
                for(GymMember member : array)
                {
                    if(member instanceof PremiumMember)
                    {
                        memberExistence= true;
                        break;
                    }
                }
                if(memberExistence)
                {
                    for(GymMember member:array)
                    {
                        if(member instanceof PremiumMember)
                        {
                            PremiumMember premium = (PremiumMember) member;
                            displayta.append("\nMember ID: "+premium.getId()+"\n");
                            displayta.append("Name: "+premium.getName()+"\n");
                            displayta.append("Location: "+premium.getLocation()+"\n");
                            displayta.append("Email: "+premium.getEmail()+"\n");
                            displayta.append("Phone: "+premium.getPhone()+"\n");
                            displayta.append("Date of Birth: "+premium.getDOB()+"\n");
                            displayta.append("Gender: "+premium.getGender()+"\n");
                            displayta.append("Membership Start Date: "+premium.getMembershipStartDate()+"\n");
                            displayta.append("Attendance: "+premium.getAttendance()+"\n");
                            displayta.append("Loyalty Points: "+premium.getLoyaltyPoints()+"\n");
                            displayta.append("Personal Trainer: "+premium.getPersonalTrainer()+"\n");
                            displayta.append("Payment of Rs."+premium.getPaidAmount()+" has been made\n");
                            displayta.append("Active Status: "+premium.getActiveStatus()+"\n");
                            displayta.append(premium.getIsFullPayment()?"Full payment has been done":"Full payment has not been done"+"\n");
                            if(premium.getIsFullPayment()==false)
                            {
                                double remainingAmount=premium.getPremiumCharge()-premium.getPaidAmount();
                                displayta.append("Payment of Rs."+remainingAmount+" is left to be paid.\n");
                            }
                            else
                            {
                                displayta.append("\nDiscount: Rs."+premium.getDiscountAmount()+"\n");
                            }
                            displayta.append("===============================================================================");
                        }
                    }
                }
                else
                {
                    displayta.append("NO PREMIUM MEMBER REGISTERED!!!");
                }
            }
        }

        else if (ae.getSource()==pcalculatediscount){
            if(tfidp.getText().isEmpty()){
                JOptionPane.showMessageDialog(prefr, "Please input value for Member ID");

            }
            try{
                int memId = Integer.parseInt(tfidp.getText());
                boolean isMemberFound = false;
                PremiumMember matchedMember = null;

                for (GymMember member : array) {
                    if (member instanceof PremiumMember){
                        PremiumMember premiummember = (PremiumMember) member;
                        if (member.getId() == memId) {
                            isMemberFound = true;
                            matchedMember = premiummember;
                            break;

                        }
                    }
                }

                if(isMemberFound){
                    if(matchedMember.getActiveStatus()) {
                        if(matchedMember.getIsFullPayment())
                        {

                            matchedMember.calculateDiscount();
                            JOptionPane.showMessageDialog(prefr, "The member "+matchedMember.getName()+" has successfully reveived 10% Discount");
                        }
                        else{
                            JOptionPane.showMessageDialog(prefr, "Member not eligible for discount. Full Payment has not been made.");
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(prefr,"Activate membership first for: "+matchedMember.getName()+" to mark attendance","Success",JOptionPane.INFORMATION_MESSAGE);

                    }
                }
                else{
                    JOptionPane.showMessageDialog(prefr,"Member with this ID does not exist!","Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            catch (NumberFormatException ex){
                JOptionPane.showMessageDialog(prefr,"ID can only have number values");
            }

        }
        else if (ae.getSource()==PayDue){
            if(tfidp.getText().isEmpty()){
                JOptionPane.showMessageDialog(prefr, "Please input value for Member ID");

            }
            try{
                int preid = Integer.parseInt(tfidp.getText());
                double paidAmount = Double.parseDouble(tfpaidp.getText());
                boolean isMemberFound = false;
                PremiumMember matchedMember = null;

                for (GymMember member : array) {
                    if (member instanceof PremiumMember){
                        PremiumMember premiummember = (PremiumMember) member;
                        if (member.getId() == preid) {
                            isMemberFound = true;
                            matchedMember = premiummember;
                            break;

                        }
                    }
                }

                if(isMemberFound){
                    if(matchedMember.getActiveStatus()) {
                        String message = matchedMember.payDueAmount(paidAmount);
                        JOptionPane.showMessageDialog(prefr,message);
                    }
                    else{
                        JOptionPane.showMessageDialog(prefr,"Activate membership first ");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(prefr,"Member with this ID does not exist!","Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            catch (NumberFormatException e){
                JOptionPane.showMessageDialog(prefr,"ID can only have number values");
            }

        }
        else if (ae.getSource()==PSave || ae.getSource()==RSave){

            try {
                File file = new File("MemberDetails.txt");
                FileWriter writer = new FileWriter(file);

                
                writer.write("Regular and Premium Member Details\n\n");

                
                writer.write(String.format(
                        "%-5s %-12s %-15s %-15s %-20s %-25s %-8s %-18s %-20s %-15s %-10s %-7s %-10s %-10s %-10s\n",
                        "ID", "Attendance", "Name", "Location", "Phone", "Email",
                        "Gender", "DOB", "Membership Start", "Loyalty Pts", "Status",
                        "Plan", "Price", "Trainer", "Paid Amt", "Discount"
                    ));

                writer.write("----- ------------ --------------- --------------- -------------------- ------------------------- --------- -------------------- -------------------- -------------- ---------- ------- ---------- ---------- ----------\n");

                // Loop to save member data
                for (GymMember member : array) {
                    String plan = "NA", trainer = "NA", paidAmt = "NA", discount = "NA", price = "NA";

                    if (member instanceof RegularMember) {
                        RegularMember rm = (RegularMember) member;
                        plan = rm.getPlan();
                        price = "Rs." + rm.getPrice();
                    } else if (member instanceof PremiumMember) {
                        PremiumMember pm = (PremiumMember) member;
                        trainer = pm.getPersonalTrainer();
                        paidAmt = "Rs." + pm.getPaidAmount();
                        discount = pm.getIsFullPayment() ? "Rs." + pm.getDiscountAmount() : "NA";
                        price = "Rs." + pm.getPremiumCharge();
                    }

                    writer.write(String.format(
                            "%-5d %-12d %-15s %-15s %-20s %-25s %-8s %-18s %-20s %-15.2f %-10s %-7s %-10s %-10s %-10s\n",
                            member.getId(),
                            member.getAttendance(),
                            member.getName(),
                            member.getLocation(),
                            member.getPhone(),
                            member.getEmail(),
                            member.getGender(),
                            member.getDOB(),
                            member.getMembershipStartDate(),
                            member.getLoyaltyPoints(),
                            member.getActiveStatus() ? "Active" : "Inactive",
                            plan,
                            price,
                            trainer,
                            paidAmt,
                            discount
                        ));
                }

                writer.close();
                JOptionPane.showMessageDialog(prefr, "Details Saved To File Successfully!!", "Saved", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                System.out.println("Exception Occurred : " + ex);
                JOptionPane.showMessageDialog(prefr, "Error saving member details!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        else if (ae.getSource()==PRead || ae.getSource()==RRead){
                    displayframe.setVisible(true);
                    try {
                        FileReader fileReader = new FileReader("MemberDetails.txt");
                        int character;

                        
                        while ((character = fileReader.read()) != -1) {
                            char ch = (char) character;
                            displayta.append(String.valueOf(ch)); 
                        }

                        fileReader.close();

                    } catch (Exception ex) {
                        System.out.println("Exception Occurred: " + ex);
                        JOptionPane.showMessageDialog(prefr, "Error reading member details!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            
        }
    }



                            

   