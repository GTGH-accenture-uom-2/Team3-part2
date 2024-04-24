package gr.accenture.team3.controllers;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import gr.accenture.team3.dto.VaccinationDTO;
import gr.accenture.team3.models.Vaccination;
import gr.accenture.team3.services.VaccinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/vaccination")
public class VaccinationController {

    @Autowired
    VaccinationService vaccinationService;
    @PostMapping("/add")
    public List<Vaccination> addVaccination(@RequestBody Vaccination vaccination) {

        return vaccinationService.addVaccination(vaccination);
    }
    @GetMapping("/all")
    public List<Vaccination> getVaccinations(){
        return vaccinationService.getVaccinations();
    }

    @GetMapping("/status")
    public VaccinationDTO getVaccinationStatus(@RequestParam String amka){
        return vaccinationService.getVaccinationStatus(amka);
    }

    @PostMapping("/addByDoctor/amka/{amka}/id/{id}/expirationDate/{expirationDate}")
    public Vaccination declareVaccination(@PathVariable("amka") String amka,
                                          @PathVariable("id") Long id,
                                          @PathVariable("expirationDate") LocalDate expirationDate){
        return vaccinationService.declareVaccination(amka,id,expirationDate);
    }


        @GetMapping(value = "/QR", produces = MediaType.IMAGE_PNG_VALUE)
        public byte[] generateQRCodeImage(@RequestParam("amka") String amka,
                                          @RequestParam("width") int width,
                                          @RequestParam("height") int height) throws WriterException, IOException {
            String vaccinationStatus = vaccinationService.getVaccinationSInsured(amka).toString();
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = qrCodeWriter.encode(vaccinationStatus,BarcodeFormat.QR_CODE, width, height);

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            MatrixToImageWriter.writeToStream(bitMatrix, "PNG", outputStream);

            return outputStream.toByteArray();
        }
}
