package com.souro;

import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.pdf.PDFParser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.ContentHandler;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class Tika_ExtractingPDFDoc {
    public static void main(String args[]) throws Exception {

        ContentHandler handler = new BodyContentHandler();
        Metadata metadata = new Metadata();
        InputStream inputstream = new FileInputStream(new File("/home/souro/Desktop/MindMajix/solr-8.9.0/example/exampledocs/solr-word.pdf"));
        ParseContext pcontext = new ParseContext();
        PDFParser pdfparser = new PDFParser();

        pdfparser.parse(inputstream, handler, metadata,pcontext);
        System.out.println("Contents of the PDF :" + handler.toString());

        System.out.println("Metadata of the PDF:");
        String[] metadataNames = metadata.names();

        for(String name : metadataNames) {
            System.out.println(name+ " : " + metadata.get(name));
        }
    }
}
