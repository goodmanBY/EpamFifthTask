<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="3.0">

    <xsl:template match="/">
        <html>
            <body>
                <h1>Deposits</h1>
                <table border="2">
                    <tr>
                        <th>Bank name</th>
                        <th>Country</th>
                        <th>Deposit type</th>
                        <th>Depositor</th>
                        <th>Account ID</th>
                        <th>Amount, $</th>
                        <th>Profitability, %</th>
                        <th>Time Constraints, months</th>
                    </tr>
                    <xsl:for-each select="bank/deposit">
                        <tr>
                            <td>
                                <xsl:value-of select="bankName"/>
                            </td>
                            <td>
                                <xsl:value-of select="country"/>
                            </td>
                            <td>
                                <xsl:value-of select="depositType"/>
                            </td>
                            <td>
                                <xsl:value-of select="depositor"/>
                            </td>
                            <td>
                                <xsl:value-of select="accountId"/>
                            </td>
                            <td>
                                <xsl:value-of select="amount"/>
                            </td>
                            <td>
                                <xsl:value-of select="profitability"/>
                            </td>
                            <td>
                                <xsl:value-of select="timeConstraints"/>
                            </td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
