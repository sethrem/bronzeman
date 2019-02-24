# BronzeMan-Mode Rune-Lite Plugin OSRS
BronzeMan-Mode Plugin for Rune-lite created by Sethrem. Recreation of GUDI's (Ronan's) bronze-man rune-lite plugin for general public release.
Original creator and inspiration for this plugin: https://www.youtube.com/watch?v=GFNfa2saOJg

IMPORTANT: Setting up Rune-Lite using version control (e.g. git) you can keep your built rune-lite source up to date by pulling from up-stream and it will not remove the bronzeman-mode plugin.

NOTE:
 1. WHEN THE PLUGIN IS ENABLED ALL ITEMS IN YOUR INVENTORY/EQUIPMENT AND BANK WILL BE "UNLOCKED".
    a. To prevent this from occuring it is reccommended you either start a new lvl-3 account or clear your inventory/equipment and bank before  
        using the plugin by trading your items over (defeats the bronze-man grind).
        
Features:
  1. Restricts buying items from the g.e. until that item is obtained through self-sufficent methods or from pking other players.
  2. Shows an item unlock graphic every time you obtain an item for the first time.
  3. Unlocks are handled per account so you can have multiple bronze-men or not effect the status of your bronze-man accounts.
  
Setup guide:
  1. Build RuneLite with your IDE of preference (reccommend IntelliJ) https://github.com/runelite/runelite/wiki/Building-with-IntelliJ-IDEA
  2. Download this repo and extract the bronzeman folder into your 'runelite-client/src/main/java/net/runelite/client/plugins/' a.k.a.
     '/net/runelite/client/plugins/' folder. It should now look like this: https://prnt.sc/mp8zjv
  3. Compile RuneLite (If you're using an IDE you just have to run the main RuneLite Class found in 'net.runelite.client.RuneLite.java')
  4. ~~Paste the 'item-unlocked.png' into the 'runelite-client/main/resources/' folder. http://prntscr.com/mp6doo~~
  4. Enable the plugin on RuneLite's plugin sidebar.
  5. Start your Bronze-Man Mode Adventure!!!!
