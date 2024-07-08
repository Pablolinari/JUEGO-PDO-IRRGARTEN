require_relative 'Weapon'
require_relative 'Shield'
require_relative 'Dice'
require_relative 'GameState'
require_relative 'Monster'
require_relative 'Player'
require_relative 'Labyrinth'
require_relative 'Game'
require_relative 'controller'
require_relative 'textUI'
include Irrgarten
    p1 = Player.new('A',2.4,2)
    p2 = Player.new('B',2.12,3.2)

    m1 = Monster.new('M1',6,7)
    m2 = Monster.new('M2',5,2)

    w = Weapon.new(4,4)
    s = Shield.new(1,8)
    l = Labyrinth.new(3,3,1,1)
    l.add_block(Orientation::HORIZONTAL,0,0,2)
    l.add_monster(0,2,m2)
    l.add_monster(2,2,m1)
    l.put_player(Directions::UP,)
    
    
    #vie = UI::TextUI.new
    #control = Control::Controller.new(game,vie)
    #control.play()

