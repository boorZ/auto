package com.auto.gui;

import com.auto.gui.service.IMenubarService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 描述
 *
 * @author 周林
 * @version 1.0
 * @date 2021/5/8 17:01
 */
public class AutoMain {

//    @Test
//    public void mainTest() {
//        createMain();
//    }

    public void mainTest() {
        JFrame jf = new JFrame("演示卡片布局");
        jf.setSize(500, 400);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CardLayout layoutCard = new CardLayout(10, 10);
        JPanel jp1 = new JPanel();
        JPanel jp2 = new JPanel(layoutCard); //面板2为卡片布局

        jf.add(jp1, "Center");//面板1的位置
        jf.add(jp2, "South");//设置面板2位置

        JButton button1 = new JButton("HR查询");
        JButton button2 = new JButton("环安查询");
        JButton button3 = new JButton("行政查询");
        jp1.add(button1);
        jp1.add(button2);
        jp1.add(button3);

        JPanel jp3 = new JPanel();
        JPanel jp4 = new JPanel();
        JPanel jp5 = new JPanel();

        //把三个面板加入到面板2中
        jp2.add(jp3, "0"); //加入面板3,第一张
        jp2.add(jp4, "1"); //加入面板4,第二张
        jp2.add(jp5, "2"); //加入面板5.第三张

        //建三个文本框
        JTextArea textArea1 = new JTextArea(10, 20); //5行10列的文本区域
        textArea1.setLineWrap(true); //设置自动换行,默认为 false
        textArea1.setForeground(Color.BLUE);
        textArea1.setText("HR查询");

        JTextArea textArea2 = new JTextArea(10, 20);
        textArea2.setLineWrap(true);
        textArea2.setForeground(Color.red);
        textArea2.setText("环安查询");

        JTextArea textArea3 = new JTextArea(10, 20);
        textArea3.setLineWrap(true);
        textArea3.setForeground(Color.GREEN);
        textArea3.setText("行政查询");

        jp3.add(textArea1);
        jp4.add(textArea2);
        jp5.add(textArea3);

        //创建响应动作监听器类，重写ActionListener接口的actionPerformed()方法
        class bt_hander implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {   //show(Container parent, String name); 显示指定名称的一张
                if (e.getSource() == button1) {
                    layoutCard.show(jp2, "0");
                }
                ; //显示第一张
                if (e.getSource() == button2) {
                    layoutCard.show(jp2, "1");
                }
                ; //显示第二张
                if (e.getSource() == button3) {
                    layoutCard.show(jp2, "2");
                }
                ; //显示第三张
            }
        }
        // 注册按钮监听事件
        button1.addActionListener(new bt_hander());
        button2.addActionListener(new bt_hander());
        button3.addActionListener(new bt_hander());

        jf.setVisible(true);  // 显示窗口

    }

    public static void main(String[] args) {
        // 确保一个漂亮的外观风格
//        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame jf = new JFrame("AUTO");
        jf.setBounds(500, 200, 500, 500);
        // 设置默认的关闭窗口
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        jf.setLayout(null);

        // 菜单栏
        IMenubarService.createMenuBar(jf);

        // 主体
        Panel topPanel = new Panel();
        Panel mainPanel = new Panel();
        topPanel.setBackground(Color.GREEN);
        mainPanel.setBackground(Color.RED);

        jf.add(topPanel, BorderLayout.NORTH);
        jf.add(mainPanel, BorderLayout.CENTER);

        // 工具栏
//        JToolBar jt = createTool();
//        jf.setContentPane(jt);


//        JButton homePage = new JButton("主页");
//        JButton set = new JButton("设置");
//        mainPanel.add(homePage);
//        mainPanel.add(set);
        // 卡片布局
//        Panel cardPanel = createCardPanel();
//        jf.add(mainPanel);

        // 这个最好放在最后，否则会出现视图问题。
        jf.setVisible(true);
    }

    static final private String OPEN = "OPEN";
    static final private String SAVE = "SAVE";
    static final private String NEW = "NEW";

    private static JToolBar createTool() {
        JToolBar jt = new JToolBar();
        jt.setOpaque(true);
        JButton button;
        button = makeNavigationButton(NEW, "新建一个文件", "新建");
        jt.add(button);
        button = makeNavigationButton(OPEN, "打开一个文件", "打开");
        jt.add(button);
        button = makeNavigationButton(SAVE, "保存当前文件", "保存");
        jt.add(button);
        return jt;
    }

    private static JButton makeNavigationButton(String actionCommand, String toolTipText, String altText) {
        //初始化工具按钮
        JButton button = new JButton();
        //设置按钮的命令
//        button.setActionCommand(actionCommand);
        //设置提示信息
        button.setToolTipText(toolTipText);
//        button.addActionListener(AutoMain.class);
        button.setText(altText);
        return button;
    }

    private static Panel createCardPanel() {
        Panel cardPanel = new Panel(new CardLayout(10, 10));

        Panel p1 = new Panel();
        p1.add(new Button("one"));
        p1.add(new Button("two"));
        p1.add(new Button("three"));
        cardPanel.add("BUTTON", p1);

        Panel p2 = new Panel();
        p2.add(new Label("label1"));
        p2.add(new Label("label2"));
        p2.add(new Label("label3"));
        cardPanel.add("LABEL", p2);

        return cardPanel;
    }
}
