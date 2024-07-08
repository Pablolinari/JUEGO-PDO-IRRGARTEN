require_relative 'Directions'
require_relative 'Dice'
require_relative 'Orientation'
require_relative 'Player'
require_relative 'Monster'
module Irrgarten
    class Labyrinth
        @@BLOCK_CHAR = 'X'
        @@EMPTY_CHAR = '-'
        @@COMBAT_CHAR = 'C'
        @@MONSTER_CHAR = 'M'
        @@EXIT_CHAR = 'E'
        @@ROW = 0
        @@COL = 1
        def initialize(nrows,ncols,erow,ecol)
            @n_rows = nrows
            @n_cols = ncols
            @exit_row = erow
            @exit_col = ecol
            @monsters = Array.new(@n_rows){Array.new(@n_cols)}
            @labyrinth = Array.new(@n_rows){Array.new(@n_cols,@@EMPTY_CHAR)}
            @players = Array.new(@n_rows){Array.new(@n_cols)}
            @labyrinth[erow][ecol] = @@EXIT_CHAR
        end

        def spread_players(players)
            for p in players
                pos = random_empty_pos()
                monster = put_player_2D(-1,-1,pos[@@ROW],pos[@@COL],p)
            end
        end
        def have_a_winner
            return @players[@exit_row][@exit_col] != nil

        end
        def to_s
            cadena =""
            decor = " * "* (@n_cols+2)
            cadena.concat(decor,"\n")
            for i in 0...@n_rows
                cadena.concat(" * ")
                for j in 0...@n_cols
                    cadena.concat(" ",@labyrinth[i][j]," ")
                end
                cadena.concat(" *\n")
            end
            cadena.concat(decor,"\n")
            return cadena
        end
        def add_monster(row,col,monster)
            if pos_ok(row,col) && empty_pos(row,col)
                @labyrinth[row][col] = @@MONSTER_CHAR
                @monsters[row][col] = monster
                @monsters[row][col].set_pos(row,col)
                
            end
        end
        def add_block(orientation , start_row ,start_col, lenght)
            if orientation == Orientation::VERTICAL 
                incRow = 1
                incCol = 0
            else
                incRow = 0
                incCol = 1

            end
            
            row = start_row
            col = start_col
            
            while(pos_ok(row,col) && empty_pos(row,col) && (lenght > 0))
                @labyrinth[row][col] = @@BLOCK_CHAR
                row += incRow
                col += incCol
                lenght -=1
            end

        end
        def valid_moves(row,col)
            directions = Array.new()
            if can_step_on(row+1,col)
                directions.push(Directions::DOWN)
            end
            if can_step_on(row-1,col)
                directions.push(Directions::UP)
            end
            if can_step_on(row,col+1)
                directions.push(Directions::RIGHT)
            end
            if can_step_on(row,col-1)
                directions.push(Directions::LEFT)
            end
            return directions
        end
        def put_player(direction,player)
            old_row = player.row
            old_col = player.col
            posicion = dir_2_pos(old_row, old_col, direction)
            put_player_2D(old_row, old_col, posicion[@@ROW], posicion[@@COL], player)
        end

        private

        def pos_ok(row ,col)
            return (0 <= row && row < @n_rows && 0 <= col && col < @n_cols)
        end
        def empty_pos(row,col)
            return @labyrinth[row][col] == @@EMPTY_CHAR
        end
        def monster_pos(row,col)
            return @labyrinth[row][col] == @@MONSTER_CHAR
        end
        def exit_pos(row,col)
            return @labyrinth[row][col] == @@EXIT_CHAR
        end
        def combat_pos(row,col)
            return @labyrinth[row][col] == @@COMBAT_CHAR
        end
        def can_step_on(row,col)
            return pos_ok(row,col) && (empty_pos(row,col)||monster_pos(row,col)||exit_pos(row,col))
        end
        def update_old_pos(row,col)
            if pos_ok(row,col) 
                if combat_pos(row,col)
                    @labyrinth[row][col] = @@MONSTER_CHAR
                else
                    @labyrinth[row][col] =@@EMPTY_CHAR
                end
            end
        end
        def dir_2_pos(row,col,direction)
            if direction == Directions::UP 
                return [row-1,col]
            elsif direction == Directions::DOWN
                return [row+1,col]
            elsif direction == Directions::RIGHT 
                return [row,col+1]
            else
                return [row,col-1]
            end
        end
        def random_empty_pos
            col = Dice.random_pos(@n_cols)
            row = Dice.random_pos(@n_rows)
            while (!pos_ok(row,col) || !empty_pos(row,col))
                col =Dice.random_pos(@n_cols)
                row =Dice.random_pos(@n_rows)
            end
            return [row,col]
        end
        def put_player_2D(old_row,old_col,row,col,player)
            output = nil
            if can_step_on(row,col)
                if pos_ok(old_row,old_col)
                    jugador = @players[old_row][old_col]
                    if player == jugador
                        update_old_pos(old_row, old_col)
                        player.set_pos(old_row,old_col)
                    end
                end
                if monster_pos(row,col)
                    @labyrinth[row][col]=@@COMBAT_CHAR
                    output = @monsters[row][col]
                else
                    @labyrinth[row][col] = player.number.to_s
                end   
            
                @players[row][col] = player  
                player.set_pos(row,col)
            end
            return output
        end
    
    end
end
