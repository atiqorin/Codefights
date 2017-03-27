class SimplifyPath {
    String simplifyPath(String path) {
        String[] folders = path.split("/");
        if (folders.length == 0) {
            return "/";
        }
        String[] simplified = new String[folders.length];
        int indx = 0;
        for (String folder : folders) {
            if (folder.equals("..") || folder.equals(".") || folder.equals("")) {
                if (folder.equals("..") && indx > 0) {
                    indx--;
                }
                continue;
            }
            simplified[indx++] = folder;
        }
        if (indx == 0) {
            return "/";
        }
        String result = "";
        for (int i = 0; i < indx; i++) {
            result += "/" + simplified[i];
        }
        return result;
    }
}