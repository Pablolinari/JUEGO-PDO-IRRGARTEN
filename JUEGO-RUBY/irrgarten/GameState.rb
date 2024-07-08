module Irrgarten
    class GameState

        attr_reader :labyrinthv , :players , :monsters , :current_player , :winner , :log 

        def initialize(lbrnth , plyrs , mnstr ,cplyr, wnnr ,lg )
            @labyrinthv = lbrnth
            @players = plyrs
            @monsters = mnstr
            @current_player = cplyr
            @winner = wnnr 
            @log = lg 
        end

        
    end
end

