package impressao;

import java.awt.GraphicsConfiguration;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.ServiceUI;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.print.attribute.standard.MediaSizeName;
import javax.print.attribute.standard.OrientationRequested;
import javax.print.attribute.standard.Sides;
import javax.print.event.PrintJobAdapter;
import javax.print.event.PrintJobEvent;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Printer { 

JFrame frame; 
JButton btn; 
private boolean PrintJobDone = false; 


Printer(String FileToPrint, String pMode) { 

try { 



// Open the image file 
InputStream is = new BufferedInputStream(new FileInputStream(FileToPrint)); 

// Find the default service 
DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE; 

if (pMode != null && pMode.equalsIgnoreCase("TXT")) 
; 
else if (pMode != null && pMode.equalsIgnoreCase("PS")) 
flavor = DocFlavor.INPUT_STREAM.POSTSCRIPT; 
else if (pMode != null && pMode.equalsIgnoreCase("PDF")) 
flavor = DocFlavor.INPUT_STREAM.PDF; 
else if (pMode != null && pMode.equalsIgnoreCase("JPG")) 
flavor = DocFlavor.INPUT_STREAM.JPEG; 
else if (pMode != null && pMode.equalsIgnoreCase("GIF")) 
flavor = DocFlavor.INPUT_STREAM.GIF; 
else if (pMode != null && pMode.equalsIgnoreCase("PNG")) 
flavor = DocFlavor.INPUT_STREAM.PNG; 
else if (pMode != null && pMode.equalsIgnoreCase("PCL")) 
flavor = DocFlavor.INPUT_STREAM.PCL; 
else if (pMode != null && pMode.equalsIgnoreCase("RAW")) 
flavor = DocFlavor.INPUT_STREAM.AUTOSENSE; 

PrintService dservice = PrintServiceLookup.lookupDefaultPrintService(); 

PrintService[] services = PrintServiceLookup.lookupPrintServices(flavor, null); 

if (services == null || services.length < 1) 
services = PrintServiceLookup.lookupPrintServices(null, null); 

PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet(); 
aset.add(new Copies(1)); 
aset.add(OrientationRequested.PORTRAIT); 
aset.add(Sides.ONE_SIDED); 
aset.add(MediaSizeName.ISO_A4); 


PrintService service = ServiceUI.printDialog( 
(GraphicsConfiguration) null, 
60, 60, 
services, 
(PrintService) dservice, 
(DocFlavor) flavor, 
aset); 

if (service != null) { 

// Create the print job 
final DocPrintJob job = service.createPrintJob(); 

Doc doc = new SimpleDoc(is, flavor, null); 

// Monitor print job events; for the implementation of PrintJobWatcher, 

PrintJobWatcher pjDone = new PrintJobWatcher(job); 



try { 

// Print it 

job.print(doc, (PrintRequestAttributeSet) aset); 

} catch (PrintException e) { 
e.printStackTrace(); 
} 


// Wait for the print job to be done 
pjDone.waitForDone(); 

} 

// It is now safe to close the input stream 
is.close(); 

} catch (IOException e) { 
e.printStackTrace(); 
} catch (Exception e) { 
e.printStackTrace(); 
} finally { 

try { 

synchronized (Printer.this) { 
PrintJobDone = true; 
Printer.this.notify(); 
} 
} catch (Exception e) { 
e.printStackTrace(); 
} 

} 
} 


public synchronized void waitForDone() { 
try { 
while (!PrintJobDone) { 
wait(); 
} 
} catch (InterruptedException e) { 
e.printStackTrace(); 
} 
} 



class PrintJobWatcher { 

// true iff it is safe to close the print job's input stream 
boolean done = false; 

int lastEvent = 0; 


PrintJobWatcher(DocPrintJob job) { 

// Add a listener to the print job 
job.addPrintJobListener( 
new PrintJobAdapter() { 

public void printJobRequiresAttention(PrintJobEvent pje) { 
lastEvent = pje.getPrintEventType(); 
System.err.println("* Erro na Impressora:" + pje); 

} 

public void printDataTransferCompleted(PrintJobEvent pje) { 
lastEvent = pje.getPrintEventType(); 
System.err.println("* Ficheiro enviado para a Impressora "); 

} 

public void printJobCanceled(PrintJobEvent pje) { 
lastEvent = pje.getPrintEventType(); 
allDone(); 
} 


public void printJobCompleted(PrintJobEvent pje) { 
lastEvent = pje.getPrintEventType(); 
allDone(); 
} 


public void printJobFailed(PrintJobEvent pje) { 
lastEvent = pje.getPrintEventType(); 
System.err.println("* ERRO de impressão" + pje); 
// allDone(); 
} 


public void printJobNoMoreEvents(PrintJobEvent pje) { 
lastEvent = pje.getPrintEventType(); 
System.err.println("* Todos os Ficheiros foram enviados para a impressora "); 
allDone(); 
} 


void allDone() { 

synchronized (PrintJobWatcher.this) { 
done = true; 
PrintJobWatcher.this.notify(); 
} 
} 
}); 
} 


public synchronized void waitForDone() { 
try { 
while (!done) { 
wait(); 
} 
} catch (InterruptedException e) { 
e.printStackTrace(); 
} 
} 
} 

} 
