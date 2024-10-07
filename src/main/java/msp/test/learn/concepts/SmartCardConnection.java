package msp.test.learn.concepts;

import org.apache.tomcat.util.buf.HexUtils;

import javax.smartcardio.*;
import java.util.ArrayList;
import java.util.List;

public class SmartCardConnection {

    public void checkCardReader() {
        try {
            // Get the list of available terminals (card readers)
            TerminalFactory terminalFactory = TerminalFactory.getDefault();
            List<CardTerminal> terminals = terminalFactory.terminals().list();

            // Check if there are any terminals available
            if (terminals.isEmpty()) {
                System.out.println("No card readers found.");
                return;
            }

            // Select the first terminal
            CardTerminal terminal = terminals.get(0);
            System.out.println("Connecting to Card Reader: " + terminal);

            // Wait for a card to be present in the reader
            terminal.waitForCardPresent(0);

            // Connect to the card
            Card card = terminal.connect("*");
            System.out.println("Card connected: " + card);

            // Get the ATR (Answer to Reset)
            ATR atr = card.getATR();
            System.out.println("ATR: " + HexUtils.toHexString(atr.getBytes()).toUpperCase());

            // Get the basic communication channel
            CardChannel cardChannel = card.getBasicChannel();

            // Now, you can send APDU commands using the channel
            sendApduCommand(cardChannel);

            // Close the connection to the card
            card.disconnect(false);
        } catch (CardException e) {
            System.err.println("Error connecting to card: " + e.getMessage());
        }
    }

    // Method to send an APDU command to the card
    public void sendApduCommand(CardChannel cardChannel) {
        try {
            // Example APDU command to select a file
            byte[] selectApdu = new byte[] {
                    (byte)0x00, (byte)0xA4, (byte)0x04, (byte)0x00, // CLA, INS, P1, P2
                    (byte)0x0A, // Length of the file ID
                    (byte)0x31, (byte)0x32, (byte)0x33, (byte)0x34, (byte)0x35, // File ID
                    (byte)0x36, (byte)0x37, (byte)0x38, (byte)0x39, (byte)0x00
            };

            // Send the command and get the response
            ResponseAPDU response = cardChannel.transmit(new CommandAPDU(selectApdu));

            // Process the response (status bytes and data)
            System.out.println("Response: " + HexUtils.toHexString(response.getBytes()));
        } catch (CardException e) {
            System.err.println("Error sending APDU command: " + e.getMessage());
        }
    }
}
