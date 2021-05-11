package com.auto.gui.service;

import javax.swing.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

/**
 * 菜单栏相关服务
 *
 * @author 周林
 * @version 1.0
 * @date 2021/5/10 17:28
 */
public class IMenubarService {

    public static void createMenuBar(JFrame jf) {
        JMenuBar menu = new JMenuBar();
        JMenu fileMenu = createFileMenu();
        menu.add(fileMenu);
        jf.setJMenuBar(menu);
    }

    /**
     * 创建文件菜单
     */
    private static JMenu createFileMenu() {
        JMenu menu = new JMenu("文件(F)");
        //设置快速访问符
        menu.setMnemonic(KeyEvent.VK_F);
        JMenuItem item = new JMenuItem("新建(N)", KeyEvent.VK_N);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
        add(menu, "新建(N)", KeyEvent.VK_N);
        add(menu, "打开(O)", KeyEvent.VK_O);
        add(menu, "保存(S)", KeyEvent.VK_S);
        add(menu, "退出(E)", KeyEvent.VK_E);
        return menu;
    }

    private static void add(JMenu menu, String name, int mnemonic) {
        JMenuItem item = new JMenuItem(name, mnemonic);
        item.setAccelerator(KeyStroke.getKeyStroke(mnemonic, InputEvent.CTRL_MASK));
        menu.add(item);
    }
}
