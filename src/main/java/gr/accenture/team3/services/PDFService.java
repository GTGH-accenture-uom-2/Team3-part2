package gr.accenture.team3.services;

import gr.accenture.team3.models.Reservation;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

@Service
public class PDFService {
    public void createAndSavePDF(List<Reservation> reservations, String path) throws IOException {

        PDDocument document = new PDDocument();
        PDPage page = new PDPage();

        document.addPage(page);

        PDPageContentStream contentStream = new PDPageContentStream(document, page);

        contentStream.beginText();
        contentStream.setFont(PDType1Font.HELVETICA, 12);
        contentStream.setLeading(14.5f);
        contentStream.newLineAtOffset(25, 725);

        for (Reservation reservation : reservations) {
            String line = reservation.getInsured().getName() + " " + reservation.getInsured().getSurname() +
                    " - " + reservation.getTimeslot().getStartTime() + " to " + reservation.getTimeslot().getEndTime();
            contentStream.showText(line);
            contentStream.newLine();
        }

        contentStream.endText();
        contentStream.close();

        document.save(Paths.get(path).toFile());
    }
}
