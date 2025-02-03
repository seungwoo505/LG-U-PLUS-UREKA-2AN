import Link from 'next/link';

const Navbar = () => {
  return (
    <nav className="bg-gray-800 p-4">
      <ul className="flex space-x-4">
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

const HomePage = () => {
  return (
    <div>
      <Navbar />
      <h1 className="text-2xl font-bold mt-4">Welcome to My App</h1>
      <p className="mt-2">Select a menu item to get started.</p>
    </div>
  );
};

export default HomePage;
