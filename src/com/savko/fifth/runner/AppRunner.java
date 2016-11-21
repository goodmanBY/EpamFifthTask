package com.savko.fifth.runner;

import com.savko.fifth.converter.ConvertToHtml;
import com.savko.fifth.exception.ConverterException;
import com.savko.fifth.exception.ParsingException;
import com.savko.fifth.parser.DomParser;
import com.savko.fifth.parser.SaxParser;
import com.savko.fifth.parser.StaxParser;
import com.savko.fifth.validator.XmlXsdValidator;
import org.apache.log4j.Logger;

public class AppRunner {

    private final static Logger LOGGER = Logger.getLogger(AppRunner.class);
    private static final String XML_PATH = "data/deposits.xml";
    private static final String XSL_PATH = "data/deposits.xsl";
    private static final String XSD_PATH = "data/deposits.xsd";

    public static void main(String args[]) {

        try {
            //DOM Parser
            DomParser domParser = new DomParser();
            LOGGER.info(domParser.parse(XML_PATH));

            //SAX Parser
            SaxParser saxParser = new SaxParser();
            LOGGER.info(saxParser.parse(XML_PATH));

            //StAX Parser
            LOGGER.info(StaxParser.parse(XML_PATH));

            //Is XML file validates against XSD file
            LOGGER.info("Is " + XML_PATH + " validates against " +
                    XSD_PATH + "? " + XmlXsdValidator.validate(XSD_PATH, XML_PATH));

            //Converting XML and XSL files to HTML
            ConvertToHtml.convert(XSL_PATH, XML_PATH);
        } catch (ConverterException | ParsingException e) {
            LOGGER.error(e.getMessage());
        }

    }

}
