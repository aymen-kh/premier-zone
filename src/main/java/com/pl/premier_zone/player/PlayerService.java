package com.pl.premier_zone.player;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class PlayerService {


    private final PlayerRepository playerRepository;
    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;

    }
    public List<Player> getPlayers() {
        return playerRepository.findAll();
    }



    public List<Player> getPlayersByName(String searchText) {

        return playerRepository.findAll().stream()
                .filter(Player->Player.getName().toLowerCase().contains(searchText.toLowerCase()))
                .collect(Collectors.toList());

    }

   public List<Player> getPlayersByTeam(String searchText) {
        return playerRepository.findAll().stream()
                .filter(Player-> Player.getTeam_name().toLowerCase().contains(searchText.toLowerCase()))
                .collect(Collectors.toList());
   }


    public List<Player> getPlayersByPosition(String searchText) {

        return playerRepository.findAll().stream()
                .filter(Player -> Player.getPosition().toLowerCase().contains(searchText.toLowerCase()))
                .collect(Collectors.toList());
    }
    public List<Player> getPlayersByNation(String searchText) {
        System.out.println("Searching players by nation: " + searchText);
        return playerRepository.findAll().stream()
                .filter(Player -> {
                    if (Player.getNation() == null) {
                        System.out.println("Player with null nation found: " + Player.getName());
                        return false;
                    }
                    return Player.getNation().toLowerCase().contains(searchText.toLowerCase());
                })
                .collect(Collectors.toList());
    }



    public List<Player> getPlayersByTeamAndPosition(String position, String team) {
        return playerRepository.findAll().stream()
                .filter(Player->Player.getTeam_name().equals(team) && Player.getPosition().equals(position))
                .collect(Collectors.toList());
    }
    public Player addPlayer(Player player) {
        playerRepository.save(player);
        return player;
    }
    public Player updatePlayer(Player player) {
        Optional<Player> existingPlayer = playerRepository.findByName(player.getName());
        if (existingPlayer.isPresent()) {
            Player updatedPlayer = existingPlayer.get();
            updatedPlayer.setName(player.getName());
            updatedPlayer.setPosition(player.getPosition());
            updatedPlayer.setNation(player.getNation());
            updatedPlayer.setPosition(player.getPosition());
            updatedPlayer.setNation(player.getNation());
            playerRepository.save(updatedPlayer);

            return updatedPlayer;
        }
        return null;

    }

    @Transactional
    public void deletePlayer(String playerName) {
        playerRepository.deleteByName(playerName);

    }

}
