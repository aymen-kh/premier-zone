package com.pl.premier_zone.player;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/players")
public class PlayerController {


    private final PlayerService playerService;
    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }
    @GetMapping
    public List<Player> getPlayers(
            @RequestParam(required = false) String team,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String position,
            @RequestParam(required = false) String nation
            ) {
        if (team != null && position != null){
            return playerService.getPlayersByTeamAndPosition(team,position);
        }
        if (team != null){
            return playerService.getPlayersByTeam(team);
        }
       else  if (name != null){
            return playerService.getPlayersByName(name);
        }
       else if  (position != null){
            return playerService.getPlayersByPosition(position);
        }
     else  if (nation!= null){
            return playerService.getPlayersByNation(nation);
        }
else     return playerService.getPlayers();



    }
@PostMapping
    public ResponseEntity<Player> addPlayer(@RequestBody Player player) {
        Player newPlayer = playerService.addPlayer(player);
        return new ResponseEntity<>(newPlayer, HttpStatus.CREATED);
}

@PutMapping
    public ResponseEntity<Player> updatePlayer(@RequestBody Player player) {
        Player updatedPlayer = playerService.updatePlayer(player);
        if (updatedPlayer != null){
            return new ResponseEntity<>(updatedPlayer, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

}
@PutMapping("/{PlayerName}")
      public ResponseEntity<String> deletePlayer(@PathVariable String PlayerName) {
        playerService.deletePlayer(PlayerName);
        return new ResponseEntity<>("Player deleted Successfully ",HttpStatus.OK);

    }

}
