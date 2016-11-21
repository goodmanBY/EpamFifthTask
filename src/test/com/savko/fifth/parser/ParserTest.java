package test.com.savko.fifth.parser;

import com.savko.fifth.entity.Bank;
import com.savko.fifth.entity.Deposit;
import com.savko.fifth.entity.DepositType;
import com.savko.fifth.exception.ParsingException;
import com.savko.fifth.parser.DomParser;
import com.savko.fifth.parser.SaxParser;
import com.savko.fifth.parser.StaxParser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ParserTest {

    private static final String TEST_XML = "data/depositTest.xml";

    private Deposit deposit;
    private Bank testBank;
    private Deposit testDeposit;

    @Before
    public void doBefore() {
        deposit = new Deposit(3, "Bank of Norway", "Ukraine", "Vitalii Volochai", DepositType.SAVING, 5, 200000, 25, 48);
    }

    @Test
    public void testDomParsing() throws ParsingException {
        DomParser domParser = new DomParser();
        testBank = domParser.parse(TEST_XML);
        testDeposit = testBank.getDeposits().get(0);
        Assert.assertEquals(deposit, testDeposit);
    }

    @Test
    public void testSaxParser() throws ParsingException {
        SaxParser saxParser = new SaxParser();
        testBank = saxParser.parse(TEST_XML);
        testDeposit = testBank.getDeposits().get(0);
        Assert.assertEquals(deposit, testDeposit);
    }

    @Test
    public void testStaxParser() throws ParsingException {
        Bank testBank = StaxParser.parse(TEST_XML);
        testDeposit = testBank.getDeposits().get(0);
        Assert.assertEquals(deposit, testDeposit);
    }
}
