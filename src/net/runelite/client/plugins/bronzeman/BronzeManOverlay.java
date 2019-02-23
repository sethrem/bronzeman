package net.runelite.client.plugins.bronzeman;

import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayMenuEntry;
import net.runelite.client.ui.overlay.OverlayPosition;

import javax.imageio.ImageIO;
import javax.inject.Inject;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import static net.runelite.api.MenuAction.RUNELITE_OVERLAY_CONFIG;
import static net.runelite.client.ui.overlay.OverlayManager.OPTION_CONFIGURE;

/**
 *
 * @author Seth Davis
 * @Email <sethdavis321@gmail.com>
 * @Discord Reminisce#1707
 */
public class BronzeManOverlay extends Overlay {

    private final Client client;
    private final BronzemanPlugin plugin;
    private ItemUnlock currentUnlock;
    private final List<ItemUnlock> itemUnlockList;

    @Inject
    private ItemManager itemManager;

    @Inject
    public BronzeManOverlay(Client client, BronzemanPlugin plugin) {
        super(plugin);
        this.client = client;
        this.plugin = plugin;
        this.itemUnlockList = new CopyOnWriteArrayList<>();
    }

    public void addItemUnlock(int itemId) {
        itemUnlockList.add(new ItemUnlock(itemId));
    }

    @Override
    public Dimension render(Graphics2D graphics) {
        if (client.getGameState() != GameState.LOGGED_IN) {
            return null;
        }
        if (itemUnlockList.isEmpty()) {
            return null;
        }
        if (itemManager == null) {
            System.out.println("Item-manager is null");
            return null;
        }
        if (currentUnlock == null) {
            currentUnlock = itemUnlockList.get(0);
            currentUnlock.display();
            return null;
        }

        int drawY = currentUnlock.getLocationY();
        // Drawing unlock pop-up in a static location because this is how the game-mode is.
        graphics.drawImage(unlockImage(),-62, drawY, null);
        graphics.drawImage(getImage(currentUnlock.getItemId()),-50, drawY + 7, null);
        if (drawY < 10) {
            currentUnlock.setLocationY(drawY + 1);
        }
        if (currentUnlock.displayed()) {
            itemUnlockList.remove(currentUnlock);
            currentUnlock = null;
        }
        return null;
    }

    private BufferedImage unlockImage = null;
    private BufferedImage unlockImage() {
        if (unlockImage == null) {
            try {
               unlockImage = ImageIO.read(getClass().getResourceAsStream("/item-unlocked.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return unlockImage;
    }

    private BufferedImage getImage(int itemID) {
        return itemManager.getImage(itemID, 1, false);
    }

}
