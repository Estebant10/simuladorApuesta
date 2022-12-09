	  import javax.swing.*;
	  import java.awt.GridLayout;
	  import java.util.Random;
	  import java.awt.event.*;
	  import javax.swing.border.LineBorder;
	  import javax.swing.border.Border;

	  public class Ejercicio9 {

	 
	    static int modoApuesta=1;
	 
	    // Metodo principal 
	 
	    public static void main(String[] args) {
	 
	      // ##################### VENTANA #############################
	  
	      JFrame ventana = new JFrame("Apuesta");  // Ventana
	      ventana.setSize(420, 350); // 420 ancho x 350 alto  
	      ventana.setResizable(false); // No dimensionable
	      ventana.setVisible(true); // Visible
	      ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  
	      // ##################### BARRA MENU ##########################
	  
	      JMenuBar barraMenu = new JMenuBar(); // Barra menu
	      ventana.setJMenuBar(barraMenu);
	      JMenu calcular = new JMenu("Apuesta"); // Menu Apuesta
	      barraMenu.add(calcular);
	      JMenuItem empezar = new JMenuItem("Empezar"); // Submenu Empezar
	      calcular.add(empezar);
	      JMenu configurar = new JMenu("1X2 %");  // Menu Configurar
	      barraMenu.add(configurar);
	      ButtonGroup grupo = new ButtonGroup(); // Grupo radioButton
	      JRadioButtonMenuItem rbMenuItem1,rbMenuItem2,rbMenuItem3;
	      rbMenuItem1 = new JRadioButtonMenuItem("55,56 - 33,33 - 11,11"); // Submenu 5-3-1
	      rbMenuItem1.setSelected(true); // Por defecto esta opción seleccionada
	      grupo.add(rbMenuItem1);
	      configurar.add(rbMenuItem1); 
	      rbMenuItem2 = new JRadioButtonMenuItem("55,56 - 22,22 - 22,22"); // Submenu 5-2-2
	      grupo.add(rbMenuItem2);
	      configurar.add(rbMenuItem2);
	      rbMenuItem3 = new JRadioButtonMenuItem("33,33 - 33,33 - 33,33"); // Submenu 3-3-3
	      grupo.add(rbMenuItem3);
	      configurar.add(rbMenuItem3);
	      JMenu acercaDe = new JMenu("?"); // Menu Acerca de...
	      barraMenu.add(acercaDe);
	      JMenuItem sobreQuiniela = new JMenuItem("Mundia De Programacion a Objetos"); // Submenu Sobre..
	      acercaDe.add(sobreQuiniela);
	     
	      // ##################### PANEL ###############################
	  
	      JPanel panel = new JPanel(new GridLayout(1,1));  // Tipo Panel
	      JLabel labelBienvenido= new JLabel("¡ Bienvenido a su apuesta de programacion a objetos 2022 !",SwingConstants.CENTER);
	      labelBienvenido.setVerticalAlignment(SwingConstants.CENTER);
	      panel.add(labelBienvenido); // Agregar etiqueta a Panel
	      ventana.add(panel); // Agregar Panel a Ventana
	  
	      // ##################### EVENTOS MENU  #######################
	  
	      // Evento Empezar
	  
	      JLabel labelPartido = new JLabel("Partido",SwingConstants.CENTER);
	      JLabel labelPronostico= new JLabel("Pronostico",SwingConstants.CENTER);
	      Border border = LineBorder.createGrayLineBorder();
	      labelPartido.setBorder(border);
	      labelPronostico.setBorder(border);
	  
	      ActionListener accionEmpezar = new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	          panel.setLayout(new GridLayout(17,2));
	          panel.removeAll();
	          panel.add(labelPartido);
	          panel.add(labelPronostico);
	          for (int i=1, c;i<=16;i++) {
	            if (i<15) c=i; else c=15;
	            panel.add(new JLabel(""+c,SwingConstants.CENTER));
	            panel.add(new JLabel(generaCasilla(modoApuesta,c),SwingConstants.CENTER));
	          }  
	          panel.revalidate();
	        }
	      };
	  
	      // Evento Configura
	    
	      String primero = new String("Boton1");
	      String segundo = new String("Boton2");
	      String tercero = new String("Boton3");
	     
	      ActionListener accionConfigura = new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	          if (e.getActionCommand() == primero) modoApuesta=1;
	          else
	            if (e.getActionCommand() == segundo) modoApuesta=2;
	            else
	              if (e.getActionCommand() == tercero) modoApuesta=3;
	        }
	      };
	   
	      // Evento Acerca De.. 
	  
	      ActionListener accionAcercaDe = new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	          JOptionPane.showMessageDialog(ventana, "Mundial PO Version 1.0",
	          "Sobre Quiniela",JOptionPane.INFORMATION_MESSAGE); // El primer parametro muestra ventana en medio
	        }
	      };
	     
	  
	      // Asignar cada evento con su opcion de menu
	  
	      empezar.addActionListener(accionEmpezar);
	  
	      rbMenuItem1.addActionListener(accionConfigura);
	      rbMenuItem1.setActionCommand(primero);
	   
	      rbMenuItem2.addActionListener(accionConfigura);
	      rbMenuItem2.setActionCommand(segundo);
	   
	      rbMenuItem3.addActionListener(accionConfigura);
	      rbMenuItem3.setActionCommand(tercero);
	  
	      sobreQuiniela.addActionListener(accionAcercaDe);  
	    
	    }

	    // Metodo calcular pronostico casillas
	 
	    public static String generaCasilla(int modo, int casilla) {
	  
	      Random rnd = new Random();
	      int num;
	  
	      if (casilla<15) {
	        num = rnd.nextInt(9); // Devuelve 0 a 8 
	        switch(modo) {
	          case 1: // 55,56 - 33,33 - 11,11
	            switch(num) { 
	              case 0: case 1: case 2: case 3: case 4: return "1"; 
	              case 5: case 6: case 7: return "X"; 
	              case 8: return "2"; 
	            } break; 
	          case 2: // 55,56 - 22,22 - 22,22
	            switch(num) {
	              case 0: case 1: case 2: case 3: case 4: return "1"; 
	              case 5: case 6: return "X";
	              case 7: case 8: return "2";
	            } break;
	          case 3: // 33,33 - 33,33 - 33,33
	            switch(num) { 
	              case 0: case 1: case 2:   return "1"; 
	              case 3: case 4: case 5:   return "X"; 
	              case 6: case 7: case 8:   return "2"; 
	            } break;
	       }
	     }
	     else {
	       num = rnd.nextInt(4); // Devuelve 0 a 3
	       switch(num) {
	         case 0: return "0";
	         case 1: return "1";
	         case 2: return "2";
	         case 3: return "M";
	       }
	     }
	     return "";
	   }
	 }















// Positivos y Negativos
//