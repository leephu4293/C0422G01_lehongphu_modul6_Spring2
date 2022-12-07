import {Publisher} from "./publisher";
import {Author} from "./author";

export interface BookStore {
    id: number,
    title: string,
  publisher: Publisher
  totalPages: number,
  price: number,
  imageUrl: string,
  summary: string,
  quantity: number,
  author: Author
}
