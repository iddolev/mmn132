import javax.swing.*;
import java.awt.*;

public class Test
{
	
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Tester");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000, 500);
		JPanel p = new MainPanel();
		frame.add(p);
		frame.setVisible(true);
	}

	public Test() {
		// TODO Auto-generated constructor stub
	}

}
