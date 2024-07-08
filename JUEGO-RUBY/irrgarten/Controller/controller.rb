require_relative '../Directions'
require_relative '../Game'
require_relative '../UI/textUI'
module Control

  class Controller
    def initialize(game,view)
      @game = game
      @view = view
    end

    def play
      end_of_game = false
      while (!end_of_game)
        @view.show_game(@game.game_state) 
        direction = @view.next_move 
        end_of_game = @game.next_step(direction)
      end
      @view.show_game(@game.game_state)
      print("El jugador ",@game.game_state.current_player," ha ganado la partida\n")
      
    end
  end # class   
end # module        