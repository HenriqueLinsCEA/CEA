package impressao;

String textoimp="o que vai ser impresso /n /r /f";  
///n/r para novas linhas e /f para fim da pagina  
try{  
InputStream prin = new ByteArrayInputStream(textoimp.getBytes());   
docFlavor = DocFlavor.INPUT_STREAM.AUTOSENSE;  
documentoTexto = new SimpleDoc(prin, docFlavor, null);   
impressora = PrintServiceLookup.lookupDefaultPrintService(); // pega a //impressora padrao  
PrintRequestAttributeSet printerAttributes = new HashPrintRequestAttributeSet();  
printerAttributes.add(new JobName("Impressao", null));   
printerAttributes.add(OrientationRequested.PORTRAIT);   
printerAttributes.add(MediaSizeName.ISO_A4); // informa o tipo de folha  
DocPrintJob printJob = impressora.createPrintJob();  

try{   
printJob.print(documentoTexto, (PrintRequestAttributeSet)printerAttributes); //tenta imprimir  
}   
catch(PrintException e){  
JOptionPane.showMessageDialog(null, "Não foi possível realizar a impressão !!", "Erro", JOptionPane.ERROR_MESSAGE); // mostra //mensagem de erro  
}   
prin.close();  
}  
catch(Exception e){  
}  