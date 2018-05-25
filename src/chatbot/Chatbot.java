package chatbot;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Point;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Chatbot {

    private GroupLayout layout;
    private GroupLayout.ParallelGroup parallel;
    private GroupLayout.SequentialGroup sequential;
    private static Conversation conv;
    final Data data;
    static int actionFlag;
    static int subActionFlag;
    
    public Chatbot(){
        conv = new Conversation();
        data = new Data();
        actionFlag = 0;
        subActionFlag = 0;
    }
    
    private JPanel create() {
        JPanel panel = new JPanel();
        layout = new GroupLayout(panel);
        panel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        parallel = layout.createParallelGroup();
        layout.setHorizontalGroup(layout.createSequentialGroup().addGroup(parallel));
        sequential = layout.createSequentialGroup();
        layout.setVerticalGroup(sequential);
        sendBotMessage(conv.tree.root.instruccion);
        return panel;
        
    }
    
    public void sendBotMessage(String message){
        
        JLabel bot_icon = new JLabel();
        bot_icon.setIcon(new ImageIcon(getClass().getClassLoader().getResource("resources/images/robot.png")));
        
        JLabel bot_msg = new JLabel();
        bot_msg.setText("<html><body style='width:360px;'>" + message + "</body></html>");
        
        JPanel bot_bubble = new LeftArrowBubble();
        GroupLayout bot_final_msg = new GroupLayout(bot_bubble);
        
        bot_final_msg.setHorizontalGroup(
            bot_final_msg.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(bot_final_msg.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(bot_msg)
                .addContainerGap(162, Short.MAX_VALUE))
        );
        bot_final_msg.setVerticalGroup(
            bot_final_msg.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(bot_final_msg.createSequentialGroup()
                .addComponent(bot_msg)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, 1))
        );
        
        bot_bubble.setLayout(bot_final_msg);
        
        parallel.addGroup(layout.createSequentialGroup().addComponent(bot_icon).addComponent(bot_bubble));
        sequential.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(bot_icon).addComponent(bot_bubble));
        
    }
    
    public void sendUserMessage(String message){
        
        JLabel user_icon = new JLabel();
        user_icon.setIcon(new ImageIcon(getClass().getClassLoader().getResource("resources/images/user.png")));
        
        JLabel user_msg = new JLabel();
        user_msg.setText("<html><body style='width:350px;'>" + message + "</body></html>");
        
        JPanel user_bubble = new RightArrowBubble();
        GroupLayout user_final_msg = new GroupLayout(user_bubble);
        
        user_final_msg.setHorizontalGroup(
            user_final_msg.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(user_final_msg.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(user_msg)
                .addContainerGap(162, Short.MAX_VALUE))
        );
        user_final_msg.setVerticalGroup(
            user_final_msg.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(user_final_msg.createSequentialGroup()
                .addComponent(user_msg)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, 1))
        );
        
        user_bubble.setLayout(user_final_msg);
        
        parallel.addGroup(layout.createSequentialGroup().addComponent(user_icon).addComponent(user_bubble));
        sequential.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(user_icon).addComponent(user_bubble));
        
    }
    
    public void setActionFlag(int flag){
        actionFlag = flag;
    }
    
    public void setSubActionFlag(int flag){
        subActionFlag = flag;
    }
    
    public static void main(String[] args) {
        
        EventQueue.invokeLater(() -> {
            
            JFrame f = new JFrame("Chatbot");
            f.setPreferredSize(new Dimension(600, 500));
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            final Chatbot dgl = new Chatbot();
            final JPanel panel = dgl.create();
            
            JScrollPane jsp = new JScrollPane(panel);
            Dimension d = new Dimension(panel.getComponent(0).getPreferredSize());
            jsp.getVerticalScrollBar().setUnitIncrement(d.height);
            d.height *= 600;
            jsp.getViewport().setPreferredSize(d);
            jsp.getViewport().setViewPosition(new Point(0, d.height));
            jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            
            JPanel controls = new JPanel();
            JTextField txtEntrada = new JTextField();
            txtEntrada.setPreferredSize(new Dimension(480, 27));
            
            Action action = new AbstractAction()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    String mensaje = txtEntrada.getText();
                    
                    if(!"".equals(mensaje)){
                        
                        dgl.sendUserMessage(mensaje);
                        panel.validate();
                        txtEntrada.setText("");
                        
                        conv.tree.containsNode(conv.tree.root, mensaje, dgl, actionFlag, subActionFlag);
                        
                        f.revalidate();
                        JScrollBar vertical = jsp.getVerticalScrollBar();
                        vertical.setValue(vertical.getMaximum());
                        f.pack();
                        
                    }
                }
            };
            
            txtEntrada.addActionListener(action);
            controls.add(txtEntrada);
            
            controls.add(new JButton(new AbstractAction("Enviar") {
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                    String mensaje = txtEntrada.getText();
                    
                    if(!"".equals(mensaje)){
                        
                        dgl.sendUserMessage(mensaje);
                        panel.validate();
                        txtEntrada.setText("");
                        
                        conv.tree.containsNode(conv.tree.root, mensaje, dgl, actionFlag, subActionFlag);
                        
                        f.revalidate();
                        JScrollBar vertical = jsp.getVerticalScrollBar();
                        vertical.setValue(vertical.getMaximum());
                        f.pack();
                        
                    }
                    
                }
            }));
            f.add(jsp, BorderLayout.CENTER);
            f.add(controls, BorderLayout.SOUTH);
            f.pack();
            f.setLocationRelativeTo(null);
            f.setVisible(true);
        });
        
    }
    
}
