package com.sist.client;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JPanel;

import com.sist.client.DetailPanel;
import com.sist.client.HomePanel;

public class ControlPanel extends JPanel {
	FindPanel fp = new FindPanel();
	NewsPanel np = new NewsPanel();
	ChatPanel cp = new ChatPanel();
	HomePanel hp;
	DetailPanel dp;
	CardLayout card = new CardLayout();
	public ControlPanel()
	{
		hp=new HomePanel(this);
		dp=new DetailPanel(this);
		setLayout(card);
		add("home",hp);
		add("find",fp);
		add("news",np);
		add("chat",cp);
		add("detail",dp);
	}
}