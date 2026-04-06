package session06.session06.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import session06.session06.model.dto.request.TicketRequest;
import session06.session06.model.dto.response.ApiResponse;
import session06.session06.model.dto.response.TicketResponse;
import session06.session06.model.dto.response.TicketSummaryResponse;
import session06.session06.service.ParkingService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("api/v1/tickets")
@RequiredArgsConstructor
public class ParkingController {
    private final ParkingService parkingService;

    @PostMapping("/check-in")
    public ResponseEntity<ApiResponse<TicketResponse>> checkIn (@RequestBody TicketRequest req) {
        TicketResponse res = parkingService.checkIn(req);
        return ResponseEntity.ok(new ApiResponse<TicketResponse>(true, "Check-in thành công!", res));
    }
    
    @PutMapping("/check-out/{vehicleId}")
    public ResponseEntity<ApiResponse<TicketResponse>> checkOut(@PathVariable String vehicleId) {
        TicketResponse res = parkingService.checkOut(vehicleId);
        return ResponseEntity.ok(new ApiResponse<TicketResponse>(true, "Check-out thành công!", res));
    }

    @GetMapping("/summary")
    public ResponseEntity<ApiResponse<List<TicketSummaryResponse>>> getMethodName() {
        List<TicketSummaryResponse> res = parkingService.getSummaryToday();
        return ResponseEntity.ok(new ApiResponse<List<TicketSummaryResponse>>(true, "Thống kê hôm nay thành công!", res));
    }
    
}
