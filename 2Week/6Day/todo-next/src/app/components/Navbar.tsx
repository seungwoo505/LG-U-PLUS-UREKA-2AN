import Link from 'next/link';

const Navbar = () => {
  return (
    <nav className="bg-gray-800 p-4">
      <ul className="flex space-x-4">
        <li>
          <Link href="/" className="text-white hover:text-gray-300">
            Home
          </Link>
        </li>
        <li>
          <Link href="/todo" className="text-white hover:text-gray-300">
            Todo List
          </Link>
        </li>
        <li>
          <Link href="/study-note" className="text-white hover:text-gray-300">
            Study Note
          </Link>
        </li>
        <li>
          <Link href="/gallery" className="text-white hover:text-gray-300">
            Gallery
          </Link>
        </li>
      </ul>
    </nav>
  );
};

export default Navbar;