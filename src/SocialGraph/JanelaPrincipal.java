/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SocialGraph;

import ed_tp.User;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class JanelaPrincipal extends javax.swing.JFrame {

    private SocialGraph social;

    /**
     * Creates new form JanelaPrincipal
     */
    public JanelaPrincipal() {
        initComponents();
        social = new SocialGraph();

        User user1 = new User(1, 23, "Mário", "mario@hotmail.com", 1);
        User user2 = new User(2, 23, "Mário", "jorge@hotmail.com", 2);
        social.addUser(user1);
        social.addUser(user2);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Social_Graph");
        setResizable(false);

        jDesktopPane1.setBackground(java.awt.SystemColor.activeCaption);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1010, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 679, Short.MAX_VALUE)
        );

        jMenuBar1.setToolTipText("");
        jMenuBar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user.png"))); // NOI18N
        jMenu1.setText("ManageUsers");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        jMenuItem12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user_add.png"))); // NOI18N
        jMenuItem12.setText("AddUser");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem12);

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user_delete.png"))); // NOI18N
        jMenuItem1.setText("RemoveUser");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/group_add.png"))); // NOI18N
        jMenuItem3.setText("AddUserFriend");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem11.setText("print");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem11);

        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/group_link.png"))); // NOI18N
        jMenu2.setText("Graph");

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/zoom.png"))); // NOI18N
        jMenuItem2.setText("SearchUser");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/world_link.png"))); // NOI18N
        jMenuItem4.setText("Completo");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuItem5.setText("ShortPath");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuItem6.setText("CanMeet");
        jMenu2.add(jMenuItem6);

        jMenuItem7.setText("FastFriends");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem7);

        jMenuItem8.setText("8");
        jMenu2.add(jMenuItem8);

        jMenuItem9.setText("9");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem9);

        jMenuItem10.setText("10");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem10);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem10ActionPerformed
    /**
     * Botao de remove user
     *
     * @param evt
     */
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        RemoveUser remove = new RemoveUser(social);
        jDesktopPane1.add(remove);
        remove.setVisible(true);

    }//GEN-LAST:event_jMenuItem1ActionPerformed
    /**
     * Clique no botao para adicionar um utilizador novo
     *
     * @param evt
     */
    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        Scanner s = new Scanner(System.in);

        User user = new User();

        //Pedir o nome de utilizador
        System.out.println("Insira o nome do utilizador:");
        String name = s.nextLine();
        user.setNome(name);

        //Pedir a idade
        int idade = 0;
        do {
            System.out.println("Insira a idade do utilizador");
            try {
                idade = s.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Insira uma idade valida");
                idade = 0;
                s.nextLine();
            }

        } while (idade <= 0 || idade > 100);
        user.setIdade(idade);
        user.setId(1);

        //Pedir o email
        System.out.println("Insira o seu email:");
        String email = s.next();
        user.setEmail(email.toLowerCase());

        //Pedir a formaçao academica 
        int ano = 0;
        String tipoFormaçao;

        do {
            System.out.println("Insira o ano '0', negativo ou superior para sair ");
            System.out.println("Insira o ano em que se formou:");
            try {
                ano = s.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Insira um numero");
                ano = 1;
                s.nextLine();
            }
            s.nextLine();
            if (ano > 0 && ano < 2020) {
                System.out.println("Insira em que se formou:");
                tipoFormaçao = s.nextLine();
                user.addFormacao(ano, tipoFormaçao);
            }
        } while (ano > 0 && ano < 2020);

        //Pedir registo profissional 
        int ano2 = 0;
        String cargo;
        String empresa;

        do {
            System.out.println("Insira o ano '0',negativo ou superior para sair ");
            System.out.println("Insira o ano em que trabalhou numa empresa:");
            try {
                ano2 = s.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Insira um numero");
                ano2 = 1;
                s.nextLine();
            }
            s.nextLine();
            if (ano2 > 0 && ano2 < 2020) {
                System.out.println("Insira o seu cargo:");
                cargo = s.nextLine();
                System.out.println("Insira o nome da empresa");
                empresa = s.nextLine();
                user.addCargo(ano2, cargo, empresa);
            }
        } while (ano2 > 0 && ano2 < 2020);

        //Pedir skills
        String skill;
        do {
            System.out.println("Escreva 'nada' para sair");
            System.out.println("Insira um skill:");
            skill = s.nextLine();
            user.addSkill(skill);

        } while (!skill.toLowerCase().equals("nada"));

        JOptionPane.showMessageDialog(this, "Utilizador criado com sucesso");
        social.addUser(user);

    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed

    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        ShowUser addUser = new ShowUser();
        jDesktopPane1.add(addUser);
        addUser.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed
    /**
     * clique no botao para adicionar ligaçoes entre utilizadores
     *
     * @param evt
     */
    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed

        addUserFriend addFriends = new addUserFriend(social);
        jDesktopPane1.add(addFriends);
        addFriends.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        social.print();
    }//GEN-LAST:event_jMenuItem11ActionPerformed
/**
 * Clique no botao para saber se o grafo é completo ou nao
 * @param evt 
 */
    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        Boolean completo=social.completo();
        
        if(completo==true){
            JOptionPane.showMessageDialog(this, "Grafo completo");
        }else{
            JOptionPane.showMessageDialog(this, "Grafo nao completo");
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        JanelaPrincipal ja = new JanelaPrincipal();
//        User user1 = new User(1, 23, "Mário", "mario@hotmail.com", 1);
//        User user2 = new User(2, 24, "Jorge", "j@hotmail.com", 2);
//        User user3 = new User(3, 25, "Mendes", "m@hotmail.com", 3);
//        User user4 = new User(4, 26, "Leite", "leite@hotmail.com", 4);
//        User user5 = new User(5, 27, "Leite", "leitxde@hotmail.com", 5);
//        User user6 = new User(6, 27, "Leite", "leitejorge@hotmail.com", 5);
//
//        ja.social.addUser(user1);
//        ja.social.addUser(user2);
//        ja.social.addUser(user3);
//        ja.social.addUser(user4);
//        ja.social.addUser(user5);
//        ja.social.addUser(user6);
//        ja.social.addUserFriend(user1, user2);
//        ja.social.addUserFriend(user2, user4);
//        ja.social.addUserFriend(user3, user1);
//        ja.social.addUserFriend(user5, user4);
//        // social.addUserFriend(user6, user2);
//
//        ja.social.print();
//
//        System.out.println(ja.social.completo());
//
//        try {
//            ArrayList.ArrayUnorderedList<User> xd = ja.social.fastFriends("mario@hotmail.com");
//            System.out.println("print pode conhecer");
//            for (int i = 0; i <= xd.size(); i++) {
//                System.out.println(xd.removeFirst() + " ");
//
//            }
//
//        } catch (ElementNotFoundException ex) {
//            System.out.println(ex.getMessage());
//        }

        ja.social.print();

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JanelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    // End of variables declaration//GEN-END:variables
}
