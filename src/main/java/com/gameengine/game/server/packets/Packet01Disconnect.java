package com.gameengine.game.server.packets;

import com.gameengine.game.server.GameClient;
import com.gameengine.game.server.GameServer;

public class Packet01Disconnect extends Packet{

    private String username;

    public Packet01Disconnect(byte[] data){
        super(01);
        this.username = readData(data);
    }

    public Packet01Disconnect(String username){
        super(01);
        this.username = username;
    }

    @Override
    public void writeData(GameClient client) {
        client.sendData(getData());
    }

    @Override
    public void writeData(GameServer server) {
        server.sendDataToAllClients(getData());
    }

    @Override
    public byte[] getData() {
        return ("01" + this.username).getBytes();
    }

    public String getUsername(){
        return this.username;
    }
}
