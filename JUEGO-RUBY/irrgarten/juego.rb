require_relative 'Weapon'
require_relative 'Shield'
require_relative 'Dice'
require_relative 'GameState'
require_relative 'Monster'
require_relative 'Player'
require_relative 'Labyrinth'
require_relative 'Game'
require_relative 'Controller/controller'
require_relative 'UI/textUI'

juego = Irrgarten::Game.new(2)
vista = UI::TextUI.new
controlador = Control::Controller.new(juego,vista)
controlador.play