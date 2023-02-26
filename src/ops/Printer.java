package ops;
import javax.swing.*;
import java.awt.*;
import java.awt.print.*;

public class Printer {
	
	private PrinterJob job;
	private Graphics2D graphics2D;
	private boolean result;

	public void getPrint(JPanel panel) {
		
		job = PrinterJob.getPrinterJob();
		job.setJobName("Print");
		job.setPrintable(new Printable() {
			public int print(Graphics graphics, PageFormat format, int index) {
				if(index>0) {
					return Printable.NO_SUCH_PAGE;
				}
				
				graphics2D = (Graphics2D)graphics;
				graphics2D.translate(format.getImageableX()*2, format.getImageableY()*2);
				graphics2D.scale(0.6, 0.6);
				panel.paint(graphics2D);
				
				return Printable.PAGE_EXISTS;
			}
		});
		
		result = job.printDialog();
		
		if(result) {
			try {
				job.print();
			}
			catch(PrinterException e) {
				JOptionPane.showMessageDialog(panel, "Print error: " + e);
			}
		}
	}

}
