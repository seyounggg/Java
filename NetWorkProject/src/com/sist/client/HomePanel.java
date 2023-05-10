package com.sist.client;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sist.manager.MovieSystem;
import com.sist.manager.MovieVO;

import com.sist.client.PosterCard;
import com.sist.common.ImageChange;
import com.sist.manager.MovieVO;

public class HomePanel extends JPanel implements MouseListener{
	PosterCard[] pcs = new PosterCard[12];
	JPanel pan = new JPanel();
	JButton b1,b2;
	JLabel pageLa;
	ControlPanel cp;
	MovieSystem ms=new MovieSystem();
	public HomePanel(ControlPanel cp)
	{
		this.cp=cp;
		b1= new JButton("이전");
		b2= new JButton("다음");
		pageLa = new JLabel("0 page /0 page");
		
		setLayout(null);
		pan.setLayout(new GridLayout(3,4,5,5));
		
		pan.setBounds(10, 15, 900, 700); // 딱 맞추고 싶으면 이걸 키우면 됨
		add(pan);
		JPanel p = new JPanel();
		p.add(b1);
		p.add(pageLa);
		p.add(b2);
		p.setBounds(0, 750, 900, 35);
		add(p);
	}
	public void cardPrint(List<MovieVO> list)
	{
		int i=0;
		for(MovieVO vo:list)
		{
			pcs[i]= new PosterCard(vo);
			pan.add(pcs[i]);
			i++;
		}
		for(int j=0;j<pcs.length;j++) {
			pcs[j].addMouseListener(this);
		}
	}
	public void cardInit(List<MovieVO> list) 
	{
		/*for(int i=0;i<list.size();i++)
		{
			pcs[i].poLa.setIcon(null);
			pcs[i].tLa.setText("");
		}*/
		pan.removeAll();
		pan.validate();
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		for(int i=0;i<pcs.length;i++) {
			if(e.getSource()==pcs[i]) {
				
				String title=pcs[i].tLa.getText();
				MovieVO vo=ms.movieDetailData(title);
				try {
					URL url=new URL(vo.getPoster());
					Image img=ImageChange.getImage(new ImageIcon(url), 630,	500 );
					cp.dp.imgLa.setIcon(new ImageIcon(img));
					cp.dp.titleLa.setText(vo.getTitle());
					cp.dp.regdateLa.setText(vo.getRegDate());
					cp.dp.gradeLa.setText(vo.getGrade());
					cp.dp.ageLa.setText(vo.getAge());
					cp.dp.contentTa.setText(vo.getContent());
					cp.dp.keyLa.setText(vo.getKey());
					cp.card.show(cp, "detail");
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}