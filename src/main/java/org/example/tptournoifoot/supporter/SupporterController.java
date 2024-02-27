package org.example.tptournoifoot.supporter;

import org.example.tptournoifoot.ticket.TicketMapStruct;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/supporters")
public class SupporterController {
    private final SupporterService supporterService;

    public SupporterController(SupporterService supporterService) {
        this.supporterService = supporterService;
    }

    //GET tout les supporters
    @GetMapping
    public List<Supporter> findAllSupporter(){
        return supporterService.findAllSupporter();
    }

    //GET by id un supporter
    @GetMapping("/{id}")
    public SupporterDto findSupporterById(@PathVariable Integer id){
        Supporter supporter = supporterService.findSupporterById(id);

        SupporterDto supporterDto = new SupporterDto();

        supporterDto.setId(supporter.getId());
        supporterDto.setNom(supporter.getNom());
        supporterDto.setPrenom(supporter.getPrenom());
        supporterDto.setTicketsDto(
                supporter.getTickets().stream().map(
                        TicketMapStruct.INSTANCE::toDtoComplet
                ).toList()
        );

        return supporterDto;
    }

    // DELETE Supporter by id
    @DeleteMapping("/{id}")
    public void deleteSupporterById(@PathVariable Integer id){
        supporterService.deleteSupporterById(id);
    }

    //PUT (update) supporter
    @PutMapping
    public Supporter updateSupporter(@RequestBody Supporter supporter){
        return supporterService.updateSupporter(supporter);
    }

    //GET supporter par le nom
    @GetMapping("/search")
    public Supporter findByNomSupporter(@RequestParam String nom){
        return supporterService.findByNomSupporter(nom);
    }

    //POST supporter
    @PostMapping
    public Supporter saveSupporter(@RequestBody Supporter supporter){
        return supporterService.saveSupporter(supporter);
    }


}
