import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class QRCodeGenerator {
    public static void generateQRCode(String text, String filePath, int size) throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        Map<EncodeHintType, Object> hints = new HashMap<>();
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");

        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, size, size, hints);

        BufferedImage image = new BufferedImage(size, size, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, size, size);
        graphics.setColor(Color.BLACK);

        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                if (bitMatrix.get(x, y)) {
                    graphics.fillRect(x, y, 1, 1);
                }
            }
        }
        graphics.dispose();

        File outputFile = new File(filePath);
        ImageIO.write(image, "png", outputFile);
        System.out.println("QR Code saved as: " + filePath);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter text or URL for QR Code:");
        String text = scanner.nextLine();
        System.out.println("Enter filename (e.g., qr.png):");
        String filename = scanner.nextLine();
        System.out.println("Enter size (default: 300):");
        int size = scanner.hasNextInt() ? scanner.nextInt() : 300;

        try {
            generateQRCode(text, filename, size);
            System.out.println("QR Code generated successfully!");
        } catch (Exception e) {
            System.err.println("Error generating QR Code: " + e.getMessage());
        }

        scanner.close();
    }
}
