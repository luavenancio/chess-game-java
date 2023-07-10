package boardgame;

public class Board {
	private Integer rows;
	private Integer columns;
	private Piece[][] pieces;
	
	public Board(Integer rows, Integer columns) {
		if(rows<1 || columns<1) {
			throw new BoardException("Error creating board: There must be at least 1 row and 1 column.");
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}

	public Integer getRows() {
		return rows;
	}

	public Integer getColumns() {
		return columns;
	}

	
	public Piece piece (Integer row, Integer column) {
		if(!positionExists(row, column)) {
			throw new BoardException("Error: Position don't exist.");
		}
		return pieces[row][column];
	}
	
	public Piece piece (Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Error: Position don't exist.");
		}
		return pieces[position.getRow()][position.getColumn()];
	}
	
	public void placePiece(Piece piece, Position position) {
			if(thereIsAPiece(position)) {
				throw new BoardException("Error: There's already a piece on this position: " + position);
			}
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	
	public Piece removePiece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Error: Position don't exist.");
		}
		if (piece(position) == null) {
			return null;
		}
		Piece aux = piece(position);
		aux.position = null;
		pieces[position.getRow()][position.getColumn()] = null;
		return aux;
	}
	
	public Boolean positionExists(Integer row, Integer column) {
			return row >= 0 && row < rows && column >= 0 && column < columns;
	}

	public Boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}
	
	public Boolean thereIsAPiece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Error: Position don't exist.");
		}
		return piece(position) != null;
	}
	
}
