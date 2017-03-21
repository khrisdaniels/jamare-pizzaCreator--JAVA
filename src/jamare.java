
import java.awt.Toolkit;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cmjalog
 */
public class jamare extends javax.swing.JFrame {

    /**
     * Creates new form jamare
     */
    //Defining all variables
    double prprice = 8.40;
    double mrprice = 1.0;
    double onprice = 4.50;
    double ssprice = 5.50;
    double bcprice = 0.50;
    double ecprice = 0.30;
    double blkprice = 1.80;
    double gpprice = 1.50;
    double ppaprice = 3.99;
    double snprice = 1.05;
    double smallp = 6.50;
    double mediump = 8.50;
    double largep = 10.50;
    double elargep = 12.0;
    double amount = 0, chnge = 0, cost = 0, subtotal = 0, total= 0;
    int adlaw, bulan, tuig, segundo, minuto, oras;
    String topList = "";
    String typeList = "";
    String sizeList = "";
    
    //Method for real time clock and date
    public void setTime(){
        
        Thread clock = new Thread(){
            public void run() {
                try {
                    for(;;){
                    Calendar cd = new GregorianCalendar();
                    adlaw = cd.get(Calendar.DAY_OF_MONTH);
                    bulan = cd.get(Calendar.MONTH);
                    tuig = cd.get(Calendar.YEAR);
        
                    segundo = cd.get(Calendar.SECOND);
                    minuto = cd.get(Calendar.MINUTE);
                    oras = cd.get(Calendar.HOUR);
        
                    clck.setText(oras+":"+minuto+":"+segundo);
                    dt.setText(adlaw+"/"+bulan+"/"+tuig);                    
                    
                    sleep(1000);}
                } catch (InterruptedException ex) {
                    Logger.getLogger(jamare.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        clock.start();
    }
    //Method to get and calculate all items
    public void calculateItems(){
        topList = "";
        typeList = "";
        sizeList = "";        
        subtotal = 0;
        if (pType.getSelection() == null || pSize.getSelection() == null){
            JOptionPane.showMessageDialog(null, "Do not leave Toppings/Type/Size unselected.");
        }
        
        else {
        if (pepperoni.isSelected()){
            subtotal = subtotal + prprice;
            topList += pepperoni.getText()+"\n";
            
        }
        if (mushroom.isSelected()){
            subtotal = subtotal + mrprice;
            topList += mushroom.getText()+"\n";
        }
        if (onion.isSelected()){
            subtotal = subtotal + onprice;
            topList += onion.getText()+"\n";
        }
        if (sausage.isSelected()){
            subtotal = subtotal + ssprice;
            topList += sausage.getText()+"\n";
        }
        if (bacon.isSelected()){
            subtotal = subtotal + bcprice;
            topList += bacon.getText()+"\n";
        }
        if (echeese.isSelected()){
            subtotal = subtotal + ecprice;
            topList += echeese.getText()+"\n";
        }
        if (blacko.isSelected()){
            subtotal = subtotal + blkprice;
            topList += blacko.getText()+"\n";
        }
        if (gp.isSelected()){
            subtotal = subtotal + gpprice;
            topList += gp.getText()+"\n";
        }
        if (pineapple.isSelected()){
            subtotal = subtotal + ppaprice;
            topList += pineapple.getText()+"\n";
        }
        if (spinach.isSelected()){
            subtotal = subtotal + snprice;
            topList += spinach.getText()+"\n";
        }
        
        if (small.isSelected()){
            subtotal = subtotal + smallp;
            sizeList += "Size: "+small.getText()+"\n";
        }
        else if (medium.isSelected()){
            subtotal = subtotal + mediump;
            sizeList += "Size: "+medium.getText()+"\n";
        }
        else if (large.isSelected()){
            subtotal = subtotal + largep;
            sizeList += "Size: "+large.getText()+"\n";
        }
        else if (xlarge.isSelected()){
            subtotal = subtotal + elargep;
            sizeList += "Size: "+xlarge.getText()+"\n";
        }
        
        if (tc.isSelected()){
            typeList += tc.getText()+" topped with\n";
        }
        else if (mc.isSelected()){
            typeList += mc.getText()+" topped with\n";
        }
        else if (pan.isSelected()){
            typeList += pan.getText()+" topped with\n";
        }
                
        
        costscrn.setText(Double.toString(subtotal));
        
        }
    }
    
    public void payItems(){
        if (costscrn.getText().isEmpty()||amnt.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Calculate first or enter amount to pay!");
        }
        else {
            amount = Double.parseDouble(amnt.getText());
            if (amount < subtotal){
            JOptionPane.showMessageDialog(null, "Not enough money!");
        } else {
            total = subtotal;
            
            chnge = amount - total;
            
            prntscrn.setText("\tJAMARE Food Corporation\n\t     "
                    +dt.getText()+"\n\t     "
                    +clck.getText()+"\n"
                    +"-----------------------------\n"
                    +sizeList
                    +typeList
                    +topList
                    +"-----------------------------\n"
                    +"Total: "+total+"\n"
                    +"Amount: "+amount+"\n"
                    +"Change: "+chnge+"\n\n"
                    +"Your Pizza Name: "+pizzaName.getText()
         
            );
            } 
        }
    }
    public jamare() {
        initComponents();
        setTime();
        setIcon();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pType = new javax.swing.ButtonGroup();
        pSize = new javax.swing.ButtonGroup();
        window = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pepperoni = new javax.swing.JCheckBox();
        mushroom = new javax.swing.JCheckBox();
        onion = new javax.swing.JCheckBox();
        sausage = new javax.swing.JCheckBox();
        bacon = new javax.swing.JCheckBox();
        echeese = new javax.swing.JCheckBox();
        blacko = new javax.swing.JCheckBox();
        gp = new javax.swing.JCheckBox();
        pineapple = new javax.swing.JCheckBox();
        spinach = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        tc = new javax.swing.JRadioButton();
        mc = new javax.swing.JRadioButton();
        pan = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        small = new javax.swing.JRadioButton();
        medium = new javax.swing.JRadioButton();
        large = new javax.swing.JRadioButton();
        xlarge = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        pizzaName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        costscrn = new javax.swing.JTextField();
        reset = new javax.swing.JButton();
        pay = new javax.swing.JButton();
        close = new javax.swing.JButton();
        calc = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        clck = new javax.swing.JLabel();
        dt = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        prntscrn = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        amnt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("JAMARE Pizza Builder");
        setAutoRequestFocus(false);
        setResizable(false);

        window.setBackground(new java.awt.Color(39, 174, 96));
        window.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "MENU", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Purisa", 0, 24), new java.awt.Color(241, 196, 15))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Purisa", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(241, 196, 15));
        jLabel1.setText("Choose Toppings:");

        pepperoni.setFont(new java.awt.Font("Purisa", 1, 12)); // NOI18N
        pepperoni.setForeground(new java.awt.Color(241, 196, 15));
        pepperoni.setText("Pepperoni $8.40");
        pepperoni.setToolTipText("<html><img src=\""+jamare.class.getResource("pepperoni.png")+"\">");
        pepperoni.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pepperoni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pepperoniActionPerformed(evt);
            }
        });

        mushroom.setFont(new java.awt.Font("Purisa", 1, 12)); // NOI18N
        mushroom.setForeground(new java.awt.Color(241, 196, 15));
        mushroom.setText("Mushrooms $1");
        mushroom.setToolTipText("<html><img src=\""+jamare.class.getResource("mushroom.jpg")+"\">");
        mushroom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mushroomActionPerformed(evt);
            }
        });

        onion.setFont(new java.awt.Font("Purisa", 1, 12)); // NOI18N
        onion.setForeground(new java.awt.Color(241, 196, 15));
        onion.setText("Onions $4.50");
        onion.setToolTipText("<html><img src=\""+jamare.class.getResource("onions.png")+"\">");
        onion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onionActionPerformed(evt);
            }
        });

        sausage.setFont(new java.awt.Font("Purisa", 1, 12)); // NOI18N
        sausage.setForeground(new java.awt.Color(241, 196, 15));
        sausage.setText("Sausages $5.50");
        sausage.setToolTipText("<html><img src=\""+jamare.class.getResource("sausage.png")+"\">");
        sausage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sausageActionPerformed(evt);
            }
        });

        bacon.setFont(new java.awt.Font("Purisa", 1, 12)); // NOI18N
        bacon.setForeground(new java.awt.Color(241, 196, 15));
        bacon.setText("Bacon $0.50");
        bacon.setToolTipText("<html><img src=\""+jamare.class.getResource("bacon.png")+"\">");
        bacon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                baconActionPerformed(evt);
            }
        });

        echeese.setFont(new java.awt.Font("Purisa", 1, 12)); // NOI18N
        echeese.setForeground(new java.awt.Color(241, 196, 15));
        echeese.setText("Extra Cheese $0.30");
        echeese.setToolTipText("<html><img src=\""+jamare.class.getResource("echeese.jpg")+"\">");
        echeese.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                echeeseActionPerformed(evt);
            }
        });

        blacko.setFont(new java.awt.Font("Purisa", 1, 12)); // NOI18N
        blacko.setForeground(new java.awt.Color(241, 196, 15));
        blacko.setText("Black Olives $1.80");
        blacko.setToolTipText("<html><img src=\""+jamare.class.getResource("blacko.jpg")+"\">");
        blacko.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blackoActionPerformed(evt);
            }
        });

        gp.setFont(new java.awt.Font("Purisa", 1, 12)); // NOI18N
        gp.setForeground(new java.awt.Color(241, 196, 15));
        gp.setText("Green Peppers $1.50");
        gp.setToolTipText("<html><img src=\""+jamare.class.getResource("gp.png")+"\">");
        gp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gpActionPerformed(evt);
            }
        });

        pineapple.setFont(new java.awt.Font("Purisa", 1, 12)); // NOI18N
        pineapple.setForeground(new java.awt.Color(241, 196, 15));
        pineapple.setText("Pineapple $3.99");
        pineapple.setToolTipText("<html><img src=\""+jamare.class.getResource("ppap.jpg")+"\">");
        pineapple.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pineappleActionPerformed(evt);
            }
        });

        spinach.setFont(new java.awt.Font("Purisa", 1, 12)); // NOI18N
        spinach.setForeground(new java.awt.Color(241, 196, 15));
        spinach.setText("Spinach $1.05");
        spinach.setToolTipText("<html><img src=\""+jamare.class.getResource("spinach.png")+"\">");
        spinach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                spinachActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Purisa", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(241, 196, 15));
        jLabel2.setText("Pizza Type:");

        pType.add(tc);
        tc.setFont(new java.awt.Font("Purisa", 0, 12)); // NOI18N
        tc.setForeground(new java.awt.Color(241, 196, 15));
        tc.setText("Thin Crust");
        tc.setToolTipText("<html><img src=\""+jamare.class.getResource("tc.jpg")+"\">");
        tc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tcActionPerformed(evt);
            }
        });

        pType.add(mc);
        mc.setFont(new java.awt.Font("Purisa", 0, 12)); // NOI18N
        mc.setForeground(new java.awt.Color(241, 196, 15));
        mc.setText("Medium Crust");
        mc.setToolTipText("<html><img src=\""+jamare.class.getResource("mc.jpg")+"\">");
        mc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mcActionPerformed(evt);
            }
        });

        pType.add(pan);
        pan.setFont(new java.awt.Font("Purisa", 0, 12)); // NOI18N
        pan.setForeground(new java.awt.Color(241, 196, 15));
        pan.setText("Pan");
        pan.setToolTipText("<html><img src=\""+jamare.class.getResource("pan.jpg")+"\">");
        pan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                panActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Purisa", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(241, 196, 15));
        jLabel3.setText("Pizza Size:");

        pSize.add(small);
        small.setFont(new java.awt.Font("Purisa", 0, 12)); // NOI18N
        small.setForeground(new java.awt.Color(241, 196, 15));
        small.setText("Small $6.50");
        small.setToolTipText("<html><img src=\""+jamare.class.getResource("small.jpg")+"\">");

        pSize.add(medium);
        medium.setFont(new java.awt.Font("Purisa", 0, 12)); // NOI18N
        medium.setForeground(new java.awt.Color(241, 196, 15));
        medium.setText("Medium $8.50");
        medium.setToolTipText("<html><img src=\""+jamare.class.getResource("medium.png")+"\">");

        pSize.add(large);
        large.setFont(new java.awt.Font("Purisa", 0, 12)); // NOI18N
        large.setForeground(new java.awt.Color(241, 196, 15));
        large.setText("Large $10.50");
        large.setToolTipText("<html><img src=\""+jamare.class.getResource("large.png")+"\">");

        pSize.add(xlarge);
        xlarge.setFont(new java.awt.Font("Purisa", 0, 12)); // NOI18N
        xlarge.setForeground(new java.awt.Color(241, 196, 15));
        xlarge.setText("Extra Large $12");
        xlarge.setToolTipText("<html><img src=\""+jamare.class.getResource("xlarge.jpg")+"\">");

        jLabel4.setFont(new java.awt.Font("Purisa", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(241, 196, 15));
        jLabel4.setText("Name your Pizza:");

        pizzaName.setBackground(new java.awt.Color(39, 174, 96));
        pizzaName.setFont(new java.awt.Font("Purisa", 1, 12)); // NOI18N
        pizzaName.setForeground(new java.awt.Color(241, 196, 15));

        jLabel5.setFont(new java.awt.Font("Purisa", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(241, 196, 15));
        jLabel5.setText("Total Cost:");

        costscrn.setEditable(false);
        costscrn.setBackground(new java.awt.Color(39, 174, 96));
        costscrn.setFont(new java.awt.Font("Purisa", 1, 12)); // NOI18N
        costscrn.setForeground(new java.awt.Color(241, 196, 15));
        costscrn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                costscrnActionPerformed(evt);
            }
        });

        reset.setBackground(new java.awt.Color(96, 210, 170));
        reset.setFont(new java.awt.Font("Purisa", 0, 12)); // NOI18N
        reset.setForeground(new java.awt.Color(241, 196, 15));
        reset.setText("Reset");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });

        pay.setBackground(new java.awt.Color(96, 210, 170));
        pay.setFont(new java.awt.Font("Purisa", 0, 12)); // NOI18N
        pay.setForeground(new java.awt.Color(241, 196, 15));
        pay.setText("Pay");
        pay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payActionPerformed(evt);
            }
        });

        close.setBackground(new java.awt.Color(96, 210, 170));
        close.setFont(new java.awt.Font("Purisa", 0, 12)); // NOI18N
        close.setForeground(new java.awt.Color(241, 196, 15));
        close.setText("Exit");
        close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeActionPerformed(evt);
            }
        });

        calc.setBackground(new java.awt.Color(96, 210, 170));
        calc.setFont(new java.awt.Font("Purisa", 0, 10)); // NOI18N
        calc.setForeground(new java.awt.Color(241, 196, 15));
        calc.setText("Calculate");
        calc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calcActionPerformed(evt);
            }
        });

        clck.setFont(new java.awt.Font("Purisa", 0, 12)); // NOI18N
        clck.setForeground(new java.awt.Color(241, 196, 15));
        clck.setText("Time");

        dt.setFont(new java.awt.Font("Purisa", 0, 12)); // NOI18N
        dt.setForeground(new java.awt.Color(241, 196, 15));
        dt.setText("Time");

        prntscrn.setEditable(false);
        prntscrn.setBackground(new java.awt.Color(39, 174, 96));
        prntscrn.setColumns(20);
        prntscrn.setFont(new java.awt.Font("Purisa", 0, 12)); // NOI18N
        prntscrn.setForeground(new java.awt.Color(241, 196, 15));
        prntscrn.setRows(5);
        jScrollPane1.setViewportView(prntscrn);

        jLabel6.setFont(new java.awt.Font("Purisa", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(241, 196, 15));
        jLabel6.setText("Amount:");

        amnt.setBackground(new java.awt.Color(39, 174, 96));
        amnt.setFont(new java.awt.Font("Purisa", 1, 12)); // NOI18N
        amnt.setForeground(new java.awt.Color(241, 196, 15));
        amnt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amntActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout windowLayout = new javax.swing.GroupLayout(window);
        window.setLayout(windowLayout);
        windowLayout.setHorizontalGroup(
            windowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(windowLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(windowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(windowLayout.createSequentialGroup()
                        .addGroup(windowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sausage)
                            .addComponent(jLabel1)
                            .addComponent(pepperoni)
                            .addComponent(mushroom)
                            .addComponent(onion)
                            .addComponent(bacon)
                            .addComponent(echeese)
                            .addComponent(blacko)
                            .addComponent(gp)
                            .addComponent(pineapple))
                        .addGap(58, 58, 58)
                        .addGroup(windowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(windowLayout.createSequentialGroup()
                                .addGroup(windowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(xlarge)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, windowLayout.createSequentialGroup()
                                        .addGroup(windowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(medium)
                                            .addComponent(large))
                                        .addGap(26, 26, 26)))
                                .addGroup(windowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, windowLayout.createSequentialGroup()
                                        .addComponent(calc, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(pay, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(windowLayout.createSequentialGroup()
                                        .addGap(7, 7, 7)
                                        .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(close, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(23, 23, 23))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, windowLayout.createSequentialGroup()
                                .addGroup(windowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(tc)
                                    .addComponent(pan)
                                    .addComponent(mc)
                                    .addComponent(small)
                                    .addComponent(jLabel3))
                                .addGap(31, 31, 31)
                                .addGroup(windowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(pizzaName, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                                    .addComponent(costscrn)
                                    .addComponent(amnt))
                                .addGap(18, 18, 18)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE))
                    .addGroup(windowLayout.createSequentialGroup()
                        .addComponent(spinach)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(windowLayout.createSequentialGroup()
                        .addComponent(clck)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dt))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        windowLayout.setVerticalGroup(
            windowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(windowLayout.createSequentialGroup()
                .addGroup(windowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(windowLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(windowLayout.createSequentialGroup()
                        .addGroup(windowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(windowLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pepperoni)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mushroom)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(onion)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sausage)
                                .addGap(10, 10, 10)
                                .addGroup(windowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(bacon)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(windowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(echeese)
                                    .addComponent(small)))
                            .addGroup(windowLayout.createSequentialGroup()
                                .addGroup(windowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(windowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tc)
                                    .addComponent(pizzaName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(windowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(mc)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(windowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(pan)
                                    .addComponent(costscrn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(amnt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(windowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(windowLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(windowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(blacko)
                                    .addComponent(medium))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(gp)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pineapple)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spinach))
                            .addGroup(windowLayout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(windowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(windowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(pay)
                                        .addComponent(calc))
                                    .addComponent(large))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(xlarge))
                            .addGroup(windowLayout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addGroup(windowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(close)
                                    .addComponent(reset))))))
                .addGap(25, 25, 25)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(windowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clck)
                    .addComponent(dt)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(window, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(window, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pepperoniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pepperoniActionPerformed

    }//GEN-LAST:event_pepperoniActionPerformed

    private void mushroomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mushroomActionPerformed

    }//GEN-LAST:event_mushroomActionPerformed

    private void onionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onionActionPerformed
     
    }//GEN-LAST:event_onionActionPerformed

    private void sausageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sausageActionPerformed
        
    }//GEN-LAST:event_sausageActionPerformed

    private void baconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_baconActionPerformed
        
    }//GEN-LAST:event_baconActionPerformed

    private void echeeseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_echeeseActionPerformed
        
    }//GEN-LAST:event_echeeseActionPerformed

    private void blackoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blackoActionPerformed
        
    }//GEN-LAST:event_blackoActionPerformed

    private void gpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gpActionPerformed
        
    }//GEN-LAST:event_gpActionPerformed

    private void pineappleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pineappleActionPerformed
        
    }//GEN-LAST:event_pineappleActionPerformed

    private void spinachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_spinachActionPerformed
        
    }//GEN-LAST:event_spinachActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed

        pepperoni.setSelected(false);
        mushroom.setSelected(false);
        onion.setSelected(false);
        sausage.setSelected(false);
        bacon.setSelected(false);
        echeese.setSelected(false);
        blacko.setSelected(false);
        gp.setSelected(false);
        pineapple.setSelected(false);
        spinach.setSelected(false);
        
        pType.clearSelection();
        pSize.clearSelection();
        
        pizzaName.setText("");
        costscrn.setText("");
        prntscrn.setText("");
        amnt.setText("");
        chnge = 0;
        topList = "";
        typeList = "";
        sizeList = "";        
        subtotal = 0;
    }//GEN-LAST:event_resetActionPerformed
    
    private void payActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payActionPerformed
        this.payItems();
    }//GEN-LAST:event_payActionPerformed

    private void closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeActionPerformed
        System.exit(0);
    }//GEN-LAST:event_closeActionPerformed

    private void tcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tcActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tcActionPerformed

    private void mcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mcActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mcActionPerformed

    private void panActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_panActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_panActionPerformed

    private void costscrnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_costscrnActionPerformed

        
    }//GEN-LAST:event_costscrnActionPerformed

    private void calcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calcActionPerformed
      this.calculateItems();
    }//GEN-LAST:event_calcActionPerformed

    private void amntActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amntActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_amntActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        jamare ins = new jamare();
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(jamare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jamare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jamare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jamare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jamare().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField amnt;
    private javax.swing.JCheckBox bacon;
    private javax.swing.JCheckBox blacko;
    private javax.swing.JButton calc;
    private javax.swing.JLabel clck;
    private javax.swing.JButton close;
    private javax.swing.JTextField costscrn;
    private javax.swing.JLabel dt;
    private javax.swing.JCheckBox echeese;
    private javax.swing.JCheckBox gp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JRadioButton large;
    private javax.swing.JRadioButton mc;
    private javax.swing.JRadioButton medium;
    private javax.swing.JCheckBox mushroom;
    private javax.swing.JCheckBox onion;
    private javax.swing.ButtonGroup pSize;
    private javax.swing.ButtonGroup pType;
    private javax.swing.JRadioButton pan;
    private javax.swing.JButton pay;
    private javax.swing.JCheckBox pepperoni;
    private javax.swing.JCheckBox pineapple;
    private javax.swing.JTextField pizzaName;
    private javax.swing.JTextArea prntscrn;
    private javax.swing.JButton reset;
    private javax.swing.JCheckBox sausage;
    private javax.swing.JRadioButton small;
    private javax.swing.JCheckBox spinach;
    private javax.swing.JRadioButton tc;
    private javax.swing.JPanel window;
    private javax.swing.JRadioButton xlarge;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("frameicon.png")));
    }
}
